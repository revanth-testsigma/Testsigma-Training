package com.authentication.app.Controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.authentication.app.dao.UserRepository;
import com.authentication.app.jwt.JwtUtil;
import com.authentication.app.model.Accesstokens;
import com.authentication.app.service.DefaultUserService;
import com.authentication.app.service.TokenService;
@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	DefaultUserService userService;
	
	@Autowired
	TokenService tokenService;
	
	@Autowired
	JwtUtil jwtTokenUtil;
	@GetMapping
    public String displayDashboard(Model model){
		String username;
		SecurityContext securityContext = SecurityContextHolder.getContext();
		if(securityContext.getAuthentication().getPrincipal() instanceof DefaultOAuth2User) {
		DefaultOAuth2User user = (DefaultOAuth2User) securityContext.getAuthentication().getPrincipal();
		username = user.getAttribute("name")!= null ?user.getAttribute("name"):user.getAttribute("login");
		model.addAttribute("userDetails", username);
		}else {
			User user = (User) securityContext.getAuthentication().getPrincipal();
			com.authentication.app.model.User users = userRepo.findByEmail(user.getUsername());
			username = users.getEmail();
			model.addAttribute("userDetails", username);
		}
		System.out.println(username);
		com.authentication.app.model.User userde = userService.findByEmail(username);
		System.out.println(userde.toString());
		List<Accesstokens> listTokens = tokenService.findByUser(userde);
		System.out.println(listTokens);
        model.addAttribute("listTokens", listTokens);
        return "dashboard";
    }
	
	@GetMapping("/access")
	public String giveAccess(@RequestParam(value = "valid", defaultValue = "1") Long valid, @RequestParam(value = "name", defaultValue = "token") String name) {
		String user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

		Date date = new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * valid));
		int b = (int)(Math.random()*(9999-1000+1000)+1000);
		String tokenName = user+"_"+name+b;
		final String jwt = jwtTokenUtil.generateToken(tokenName, date);
		com.authentication.app.model.User userd = userRepo.findByEmail(user);
		Accesstokens token = new Accesstokens(tokenName,jwt,userd,date.toString());
		tokenService.save(token);
		return "redirect:/dashboard?tokensuccess=1";
	}

	@RequestMapping("/tokendelete/{id}")
        public String deletetoken(@PathVariable(name = "id") int id) {
            tokenService.delete(id);
            return "redirect:/";
        }

}
