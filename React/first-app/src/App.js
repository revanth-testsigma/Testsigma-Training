import { useState } from 'react';

function Square({ value, onSquareClick }) {
  return (
    <button className="square" onClick={onSquareClick}>
      {value}
    </button>
  );
}

function Board({ player, squares, onPlay }) {
  function handleClick(i) {
    if (checkWinner(squares) || squares[i]) {
      return;
    }
    const nextSquares = squares.slice();
    nextSquares[i] = player;
    onPlay(nextSquares);
  }

  const winner = checkWinner(squares);
  let status = winner?'Winner: ' + winner:'Next player: ' + player;
  

  return (
    <>
      <div className="status">{status}</div>
      <div className="board-row">
        <Square value={squares[0]} onSquareClick={() => handleClick(0)} />
        <Square value={squares[1]} onSquareClick={() => handleClick(1)} />
        <Square value={squares[2]} onSquareClick={() => handleClick(2)} />
      </div>
      <div className="board-row">
        <Square value={squares[3]} onSquareClick={() => handleClick(3)} />
        <Square value={squares[4]} onSquareClick={() => handleClick(4)} />
        <Square value={squares[5]} onSquareClick={() => handleClick(5)} />
      </div>
      <div className="board-row">
        <Square value={squares[6]} onSquareClick={() => handleClick(6)} />
        <Square value={squares[7]} onSquareClick={() => handleClick(7)} />
        <Square value={squares[8]} onSquareClick={() => handleClick(8)} />
      </div>
    </>
  );
}

function Game() {
  const [history, setHistory] = useState([Array(9).fill(null)]);
  const [currentMove, setCurrentMove] = useState(0);
  const player = currentMove % 2 === 0?"X":"O";
  const currentSquares = history[currentMove];

  function handlePlay(nextSquares) {
    const nextHistory = [...history.slice(0, currentMove + 1), nextSquares];
    setHistory(nextHistory);
    setCurrentMove(nextHistory.length - 1);
  }

  function jumpTo(move) {
    setCurrentMove(move);
  }

  const moves = history.map((squares, move) => {
    let description = move>0?'Go to move #' + move:'Go to game start';
    
    return (
      <li key={move}>
        <button onClick={() => jumpTo(move)}>{description}</button>
      </li>
    );
  });

  return (
    <div className="game">
      <div className="game-board">
        <Board player={player} squares={currentSquares} onPlay={handlePlay} />
      </div>
      <div className="game-info">
        <ol>{moves}</ol>
      </div>
    </div>
  );
}

function checkWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i];
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
      return squares[a];
    }
  }
  return null;
}

/* Another example */

const PRODUCTS = [
  {category: "Fruits", price: "$1", stocked: true, name: "Apple"},
  {category: "Fruits", price: "$1", stocked: true, name: "Dragonfruit"},
  {category: "Fruits", price: "$2", stocked: false, name: "Passionfruit"},
  {category: "Vegetables", price: "$2", stocked: true, name: "Spinach"},
  {category: "Vegetables", price: "$4", stocked: false, name: "Pumpkin"},
  {category: "Vegetables", price: "$1", stocked: true, name: "Peas"}
];

function ProductCategoryRow({category}){
  return (
    <tr>
      <th colSpan="2">
        {category}
      </th>
    </tr>
  );
}

function ProductRow({product}){
  const name = product.stocked ? product.name:
  <span style={{color:'red'}}>
    {product.name}
  </span>
  return(
    <tr>
      <td>{name}</td>
      <td>{product.price}</td>
    </tr>
  );
}

function ProductTable({products, filterText, inStockOnly}){
  const rows = [];
  let lastCategory = null;
  products.forEach((product) => {
    if(product.name.toLowerCase().indexOf(filterText.toLowerCase()) === -1){
      return;
    }
    if (inStockOnly && !product.stocked) {
      return;
    }
    if(product.category !== lastCategory){
      rows.push(
        <ProductCategoryRow 
          category={product.category}
          key = {product.category} />
      );
    }
    rows.push(
      <ProductRow 
      product={product}
      key={product.name} />
    );

    lastCategory = product.category;
  });

  return(
    <table>
      <thead>
        <tr>
          <th>Name</th>
          <th>Price</th>
        </tr>
      </thead>
      <tbody>{rows}</tbody>
    </table>
  );
}

function SearchBar({filterText, inStockOnly, onFilterTextChange,OnInStockOnlyChange}){
  return(
    <form>
      <input type="text" value={filterText} placeholder="Search..."
       onChange={(e) => onFilterTextChange(e.target.value)} />
       <label>
       <input type="checkbox" checked={inStockOnly}
       onChange={(e) => OnInStockOnlyChange(e.target.checked)} />
       In stock only
       </label>
    </form>
  );
}

function FilterableProductTable({products}){
  const [filterText, setFilterText] = useState('');
  const [inStockOnly, setInStockOnly] = useState(false);

  return(
    <div>
      <SearchBar 
      filterText={filterText}
      inStockOnly={inStockOnly}
      onFilterTextChange={setFilterText}
      OnInStockOnlyChange={setInStockOnly}
      />
      <ProductTable
        products={products}
        filterText={filterText}
        inStockOnly={inStockOnly}
      />
    </div>
  );
}

/* Dynamic forms*/

function MyForm(){
  const [inputFields, setInputFields] = useState([
    { name: '', salary: '' }
  ])
  const handleFormChange =(index, event)=>{
    let data = [...inputFields];
  data[index][event.target.name] = event.target.value;
  setInputFields(data);
  }

  const addFields = ()=> {
    let newfield = {name:'',salary:''}
    setInputFields([...inputFields,newfield])
  }

  const submit=(e)=>{
    e.preventDefault();
    console.log(inputFields);
  }
  const remove=(index)=>{
    let data = [...inputFields];
    data.splice(index,1);
    setInputFields(data);
  }
  return(
    <div>
      <form onSubmit={submit}>
        {inputFields.map((input,index)=>{
        return(
        <div key={index}>
          <input type="text" name="name" placeholder='Name' value={input.name} onChange={event => handleFormChange(index,event)}/>
          <input type="number" name="salary" placeholder='Salary'value={input.salary} onChange={event => handleFormChange(index,event)} />
        <button onClick={() => remove(index)}>X</button>
        </div> 
        );
        })}
      
      </form>
      <button onClick={addFields}>+ Add</button>
      <button onClick={submit}>Submit</button>
    </div>
  );
}

export default function App(){
  return( 
  <>
  <h1>TIC TAC TOE Game</h1>
  <Game/>
  <br/><br/>
  <h1>Filterable Table</h1>
  <FilterableProductTable products={PRODUCTS} />
  <br/><br/>
  <h1>Dynamic Form</h1>
  <MyForm/>
  </>
  );
}