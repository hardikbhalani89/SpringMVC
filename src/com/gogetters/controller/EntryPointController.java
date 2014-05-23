package com.gogetters.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gogetters.bean.UserBean;
import com.gogetters.service.UserService;
import com.gogetters.util.Constants;


@Controller
@SessionAttributes({"sessionuser"})
public class EntryPointController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/","/index"} )
	public ModelAndView doLogin(@ModelAttribute UserBean userBean,ModelMap modelMap,HttpSession hs) {
		
		modelMap.addAttribute("userBean",userBean);
		return new ModelAndView("index", modelMap);	
	}
	
	@RequestMapping(value = "/signin")
	public ModelAndView signIn(@ModelAttribute UserBean userBean, ModelMap modelMap,HttpSession hs) {
		if((userBean=userService.signInUser(userBean))!=null){
			modelMap.addAttribute("message", "error");
			modelMap.addAttribute("userBean", userBean);
			return new ModelAndView("welcomeuser",modelMap).addObject("sessionuser",userBean);
		}
		else{
			modelMap.addAttribute("message", "error");
			userBean=new UserBean();
			return new ModelAndView("redirect:index",modelMap).addObject("sessionuser",userBean);
		}
		
		
	}
	
	
//	@RequestMapping(value = "/welcomeuser" )
//	public ModelAndView welcomeUser(@ModelAttribute UserBean userBean,ModelMap modelMap,HttpSession hs) {
//		
//		modelMap.addAttribute("userBean",userBean);
//		return new ModelAndView("index", modelMap);	
//	}
	
	@RequestMapping(value = "/registeruser")
	public ModelAndView registerUser(@ModelAttribute UserBean userBean, ModelMap modelMap,HttpSession hs) {
		
		int a=0;
		a++;
		userService.registerUser(userBean);	
	
		
		
		System.out.println("id :"+userBean.getId());
		
		modelMap.addAttribute("userBean", userBean);
		return new ModelAndView("welcomeuser",modelMap).addObject("sessionuser",userBean);
	}
	
	@RequestMapping(value = "/updateUser")
	public ModelAndView updateProfilePic(@ModelAttribute UserBean userBean, ModelMap modelMap,HttpSession hs,MultipartHttpServletRequest request) {
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		String fileName = null;
		String imagePath = null;
		String userID = null;

		List<MultipartFile> files = userBean.getFileField();

		if (request.getFileNames() != null) {
			// Iterator<String> itr=request.getFileNames();

			for (MultipartFile f : files) {

				if (f.getOriginalFilename() != null && !f.getOriginalFilename().equals("")) {

					fileName = f.getOriginalFilename();

					userID = Integer.toString(userBean.getId());
					try {
						inputStream = f.getInputStream();

						File f1 = new File(Constants.SERVER_PATH + userID);
						if (!f1.exists())
							f1.mkdir();

						imagePath = Constants.SERVER_PATH + "" + userID + "/"
								+ fileName;
						System.out.println("imagePath : " + imagePath);
						java.io.File newFile = new File(imagePath);
						if (!newFile.exists()) {
							newFile.createNewFile();
						}
						outputStream = new FileOutputStream(newFile);
						int read = 0;
						byte[] bytes = new byte[1024];

						while ((read = inputStream.read(bytes)) != -1) {
							outputStream.write(bytes, 0, read);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					imagePath = Constants.IMAGE_DISP_PATH + "" + userID + "/"
							+ fileName;
					System.out.println("Image Disp path:" + imagePath);

					userBean.setProfilePic(imagePath);
				}
			}
		}
		userService.registerUser(userBean);

		modelMap.addAttribute("userBean", userBean);
		return new ModelAndView("welcomeuser", modelMap);
	}
	
	
	
	@RequestMapping(value = "/logout")
	public ModelAndView logoutUser(@ModelAttribute UserBean userBean,ModelMap modelMap,HttpSession hs) {
			modelMap.remove("userBean");
			hs.invalidate();
			return new ModelAndView("redirect:index", modelMap).addObject("sessionuser",userBean);		
		
	}
}
