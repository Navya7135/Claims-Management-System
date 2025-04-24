package com.MemberPortal.MemberPortal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.MemberPortal.MemberPortal.Exception.ClaimStatusNotFoundException;
import com.MemberPortal.MemberPortal.VO.ClaimStatusVO;
import com.MemberPortal.MemberPortal.VO.JwtResponseVO;
import com.MemberPortal.MemberPortal.VO.MemberClaimVO;
import com.MemberPortal.MemberPortal.VO.MemberPolicyVO;
import com.MemberPortal.MemberPortal.VO.MemberPremiumVO;
import com.MemberPortal.MemberPortal.VO.MemberVO;
import com.MemberPortal.MemberPortal.feignclients.MemberClient;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class PortalController {

	@Autowired
	MemberClient memberClient;

	@RequestMapping("/")
	public String mainScreen() {
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "about");
		return "about";
	}
	
	@GetMapping(value = "/memberHome")
	public String memberHome(Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		if (token == null) {
			return "redirect:login";
		}
		return "MemberHome";

	}

	@GetMapping(value = "/login")
	public String login(Model model, HttpSession session) {
		return "login";

	}
	@ApiOperation(value="Login Here",
            notes="Provide UserName and Password",
            response = List.class)
	
	@ApiParam("id for user to be retrieved")

	@RequestMapping(value = "/loginValidation", method = RequestMethod.GET)
	public String loginValidation(@RequestParam("memberId") String memberId, @RequestParam("password") String password,
			ModelMap model, HttpSession session) {
		log.info("Start");
		ResponseEntity<?> token;
		try {
			MemberVO member = new MemberVO(memberId, password);
			token = memberClient.getToken(member);
			JwtResponseVO response = (JwtResponseVO) token.getBody();
			model.addAttribute("status", "Login Success!!");
			String tk = "Bearer "+response.getJwttoken().toString();
			System.out.println("Received Token: "+tk);
			session.setAttribute("token", tk);

		} catch (Exception e) {
			model.addAttribute("status", "Invalid Credentials!!");
			return "login";
		}
		log.info("End");
		return "redirect:memberHome";
		
	}
	
	
	@RequestMapping(value = "/submitClaim", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView submitClaim(@ModelAttribute MemberClaimVO memberClaim,@RequestParam("image") MultipartFile multipartFile,HttpSession session)  {
		String token = (String) session.getAttribute("token");
		if (!memberClient.validate(token)) {
			ModelAndView model=new ModelAndView("login");
			return model;
		}
		List<ClaimStatusVO> status=new ArrayList<>();
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		memberClaim.setBillReceipt(fileName);
		status.add(memberClient.submitClaim(memberClaim,session.getAttribute("token").toString()));
		ModelAndView model=new ModelAndView("viewStatus");
        model.addObject("claim", status);
        return model;

	}

	@ApiOperation(value="Submit Your Claim",
            notes="Provide Details",
            response = List.class)
	
	@ApiParam("id for user to be retrieved")
	@GetMapping("/showClaimSubmit")
	public String showClaimSubmit(ModelMap model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		if (!memberClient.validate(token)) {
			return "redirect:login";
		}
		List<MemberPolicyVO> policyList = memberClient.getMemberPolicy(token); 
		model.addAttribute("list", policyList);
		return "showClaimSubmit";

	}
	
	@ApiOperation(value="Check Your Claim Status",
            notes="Provide Details",
            response = List.class)
	
	@ApiParam("id for user to be retrieved")
	
	@GetMapping("/showStatusSubmit")
	public String showStatusSubmit(ModelMap model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		if (!memberClient.validate(token)) {
			return "redirect:login";
		}
		List<MemberPolicyVO> policyList = memberClient.getMemberPolicy(token); 
		model.addAttribute("list", policyList);
		return "showClaimStatus";
		}

	
	@ApiOperation(value="View Status Result",
            notes="Provide Polciy ID",
            response = List.class)
	@ApiParam("id for user to be retrieved")
	
	@SuppressWarnings("finally")
	@PostMapping("/viewStatusResult")
	@ResponseBody
	public ModelAndView viewClaimSatus(@RequestParam("policyId") String policyId, HttpSession session) throws ClaimStatusNotFoundException{
		String token = (String) session.getAttribute("token");
		boolean flag= true;
		if (!memberClient.validate(token)) {
			ModelAndView model = new ModelAndView("login");
			return model;
		}
		try {
			List<ClaimStatusVO> claimStatus = memberClient.getClaimStatus(policyId,session.getAttribute("token").toString());
			ModelAndView model = new ModelAndView("viewStatus");
			model.addObject("claim", claimStatus);
			return model;
		}
		catch(Exception e) {
			flag=false;
			throw new ClaimStatusNotFoundException("Claim Status Not Found");
		}
		finally {
			if(flag==false) {
			ModelAndView model = new ModelAndView("showClaimStatus");
			model.addObject("message", "Invalid Input");
			return model;
			}
		}
	}

	@RequestMapping("/showViewBillPage")
	public String showViewBillPage(Model model, HttpSession session) {
		String token = (String) session.getAttribute("token");
		if (!memberClient.validate(token)) {
			return "redirect:login";
		}
		return "viewBillSubmit";
	}

	
	@ApiOperation(value="View Your Bills",
            notes="Provide Policy Id",
            response = List.class)
	@ApiParam("id for user to be retrieved")
	
	@RequestMapping(value = "/viewbill", method = RequestMethod.POST)
	public ModelAndView viewBills(@RequestParam("policyId") String policyId, HttpSession session) {
		String token = (String) session.getAttribute("token");
		if (!memberClient.validate(token)) {
			ModelAndView model=new ModelAndView("login");
			return model;
		}
		List<MemberPremiumVO> memberPremium = memberClient.viewBills(session.getAttribute("token").toString(), policyId);
		System.out.println(memberPremium);
		ModelAndView model=new ModelAndView("viewBills");
		model.addObject("bill",memberPremium );
		return model;

	}
	@GetMapping(value = "/logout")
	public String logout(ModelMap model, HttpSession session) {
		session.invalidate();
		model.addAttribute("status", "Logged Out Successfully");
		return "login";

	}
}
