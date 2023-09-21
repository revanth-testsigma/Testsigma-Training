import axios, { AxiosResponse } from "axios";
import { ReactNode, createContext, useContext, useEffect, useState } from "react";


interface UserdetailsType{
    userdetails : AxiosResponse<any, any>| null;
    setUserdetails: React.Dispatch<React.SetStateAction<AxiosResponse<any, any> | null>>;
    logout: () => void;
} 
const Userdetails = createContext<UserdetailsType | undefined>(undefined);



const logout = () => {
  window.localStorage.clear();
  delete axios.defaults.headers.common["Login"]
};
export const UserdetailsProvider = ({children} : {children : ReactNode}) => {

    const [userdetails, setUserdetails] = useState<AxiosResponse<any, any>| null>(null);
    useEffect(()=>{
      const storedData = window.localStorage.getItem("userdata")
      
      if(storedData){            
        const data: any = JSON.parse(storedData) 
        axios.defaults.headers.common["Login"] = `Bearer ${data.data['password']}`         
        setUserdetails(data)
      }},[]);
    return (
      <Userdetails.Provider value={{userdetails, setUserdetails,logout}}>
        {children}
      </Userdetails.Provider>
    );
  };
  
  export const useUserdetails = () => {
    const userdetails = useContext(Userdetails);
    if (userdetails === undefined) {
      throw new Error('useUserdetails must be inside a UserdetailsProvider');
    }
    return userdetails;
  };