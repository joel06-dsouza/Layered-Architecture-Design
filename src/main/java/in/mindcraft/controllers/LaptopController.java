package in.mindcraft.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.dao.LaptopDao;
import in.mindcraft.pojos.Laptop;

@Controller
public class LaptopController {
	
	private LaptopDao laptopdao = new LaptopDao();
	
	@RequestMapping("/insertLaptop")
	public ModelAndView addLaptop(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
		int lid = Integer.parseInt(request.getParameter("lid"));
		
		String make = request.getParameter("make");
		
		double cost = Double.parseDouble(request.getParameter("cost"));
		
		Laptop laptop = new Laptop(lid, make, cost);
		
		laptopdao.addLaptop(laptop);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		
		String res = "Rows Inserted!!!";
		mv.addObject("res", res);
		return mv;
	}
	
	@RequestMapping("/showLaptop")
	public ModelAndView showLaptop() throws Exception, SQLException {
		ModelAndView mv = new ModelAndView();
		
		List <Laptop> list = laptopdao.showLaptop();
		
		System.out.println(list);
		
		mv.setViewName("resultt.jsp");
		
		mv.addObject("list",list.toString());
		
		return mv;
		
	}
	
}
