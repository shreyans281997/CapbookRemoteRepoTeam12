package com.cg.capbook.controllers;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.cg.capbook.exceptions.EmailAlreadyRegisteredException;
import com.cg.capbook.exceptions.FieldsEmptyException;
import com.cg.capbook.exceptions.FriendRequestAlreadySentException;
import com.cg.capbook.exceptions.IncorrectOldPassword;
import com.cg.capbook.exceptions.InvalidQuestionOrAnswer;
import com.cg.capbook.exceptions.InvalidUsernameOrPasswordException;
import com.cg.capbook.exceptions.LoginFieldsEmptyException;
import com.cg.capbook.exceptions.NoMailsArePresentToDeleteException;
import com.cg.capbook.exceptions.UserAccountNotFoundException;
import com.cg.capbook.exceptions.UserNotAFriendException;
import com.cg.capbook.model.Post;
import com.cg.capbook.model.UserAccount;
import com.cg.capbook.services.ICommentServices;
import com.cg.capbook.services.IEditProfileServices;
import com.cg.capbook.services.IEmailService;
import com.cg.capbook.services.IFriendRequestServices;
import com.cg.capbook.services.ILikesService;
import com.cg.capbook.services.IPostService;
import com.cg.capbook.services.IUserService;
@Controller
@SessionAttributes({"user","posts"})
public class UserServiceController {
@Autowired
	IUserService userService; 
	@Autowired
	IEmailService emailService;
	@Autowired
	IEditProfileServices editProfile;
	@Autowired
	IPostService postService;
	@Autowired
	ILikesService likeServices;
	@Autowired
	IFriendRequestServices friendServices;
	@Autowired
	ICommentServices commentServices;
	@RequestMapping("/showSignup")
	public ModelAndView signUp(@RequestParam String emailId,String password,String firstName,String secondName,String dateOfBirth, String gender, String mobileNo,String securityQue,String answer) throws EmailAlreadyRegisteredException, FieldsEmptyException {
		userService.acceptUserDetails(emailId, password, firstName, secondName, dateOfBirth, gender, mobileNo, securityQue,answer);
		return new ModelAndView("loginPage","register","You have registered successfully");}
	@RequestMapping("/forgotPassword") public ModelAndView changePassword(@RequestParam String
			emailId,String password, String securityQue,String answer) throws UserAccountNotFoundException, IncorrectOldPassword, InvalidQuestionOrAnswer {
		userService.forgotPassword(emailId, password, securityQue,answer);
		return new ModelAndView("forgotPassword","success","Password changed Successfully");
	}
	@RequestMapping("/showLogin") public ModelAndView login(@RequestParam String
			emailId,String password ) throws InvalidUsernameOrPasswordException, UserAccountNotFoundException, LoginFieldsEmptyException {
		return new ModelAndView("editProfilePage","user",userService.loginUser(emailId, password));
	}
	@RequestMapping("/updatePassword")
	public ModelAndView changePassword(@RequestParam String oldPassword, String newPassword,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IncorrectOldPassword {
		userService.changePassword(user.getEmailId(),oldPassword, newPassword);
		return new ModelAndView("editProfilePage","success","Password changed Successfully");
	}
	@RequestMapping("/updateAddress")
	public ModelAndView updateAddress(@RequestParam String city,String state,String country,String zipCode,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IncorrectOldPassword {
		editProfile.editAddress(user.getEmailId(), city, state, country, zipCode);
		return new ModelAndView("editProfilePage","success","Address Updated Successfully");
	}
	@RequestMapping("/updateBio")
	public ModelAndView updateBio(@RequestParam String bio,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IncorrectOldPassword {
		editProfile.editBio(user.getEmailId(), bio);
		return new ModelAndView("editProfilePage","success","Bio Updated Successfully");
	}
	@RequestMapping("/updateProfessionalInfo")
	public ModelAndView updateProfessionalInfo(@RequestParam String workPlace,String workExperience,String businessProfile,String mobileNo,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IncorrectOldPassword {
		editProfile.editWorkPlaceAndWorkExperience(user.getEmailId(), workPlace, workExperience, businessProfile, mobileNo);
		return new ModelAndView("editProfilePage","success","Professional Information Updated Successfully");
	}
@RequestMapping("/updatePic") public ModelAndView updatePic( @RequestParam MultipartFile file ,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IOException {
		user=userService.addProfilePic(user.getEmailId(), file);
		return new ModelAndView("editProfilePage","user",userService.addProfilePic(user.getEmailId(), file));
	}
	@RequestMapping("/sendEmail")
	public ModelAndView sendEmail( @SessionAttribute("user") UserAccount user,@RequestParam String toAddress, String subject, String messageBody) throws UserAccountNotFoundException, UserNotAFriendException {
		emailService.saveEmail(user.getEmailId(), toAddress, subject, messageBody);
		return new ModelAndView("sendEmail", "success", "Email Sent Successfully");
	}
	@RequestMapping("/showAllEmail")
	public ModelAndView showAllEmail( @SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, UserNotAFriendException {
		return new ModelAndView("ShowAllEmails", "email", emailService.getAllEmailsOfUser(user.getEmailId()));
	}
	@RequestMapping("/showEmail")
	public ModelAndView showEmail(@RequestParam String emailId,int emailChatId) throws UserAccountNotFoundException, UserNotAFriendException {
		return new ModelAndView("openEmailContent", "email", emailService.getEmail(emailId, emailChatId));
	}
	@RequestMapping("/showAllSentEmail")
	public ModelAndView showAllSentEmail( @SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, UserNotAFriendException {
		return new ModelAndView("showAllSentEmails", "email", emailService.getAllSentEmailsOfUser(user.getEmailId()));
	}
	@RequestMapping("/showSentEmail")
	public ModelAndView showSentEmail(@RequestParam String emailId,int emailChatId) throws UserAccountNotFoundException, UserNotAFriendException {
		return new ModelAndView("openSentEmailContent", "email", emailService.getSentEmail(emailId, emailChatId));
	}
	@RequestMapping("/updatePost")
	public ModelAndView updatePost(@RequestParam String postContent ,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, UserNotAFriendException {
		postService.createPostText(user.getEmailId(), postContent);
		return new ModelAndView("homePage", "posts", postService.showAllFriendsPosts(user.getEmailId()));
	}
	@RequestMapping("/getUserProfile")
	public ModelAndView getUserProfile(@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, UserNotAFriendException {
		user=userService.searchUser(user.getEmailId());
		return new ModelAndView("profilePage", "posts", postService.allPosts(user.getEmailId()));
	}
	@RequestMapping("/getEditProfile")
	public ModelAndView getEditProfile(@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IncorrectOldPassword {
		return new ModelAndView("editProfilePage","user",user);
	}
	@RequestMapping("/getHomePage")
	public ModelAndView getHomePage(@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, IncorrectOldPassword {
        return new ModelAndView("homePage","posts",postService.showAllFriendsPosts(user.getEmailId()));
	}
	@RequestMapping("/updateLikes")
	public ModelAndView updateLikes(@SessionAttribute("user") UserAccount user, @RequestParam int postId, String likedBy) throws UserAccountNotFoundException, IncorrectOldPassword {
		likeServices.updateLikes(postId, likedBy);
		likeServices.getLikesCount(postId);
        return new ModelAndView("homePage","posts",postService.showAllFriendsPosts(user.getEmailId()));
	}
	@RequestMapping("/updateLikesOnProfilePage")
	public ModelAndView updateLikesOnProfilePage(@SessionAttribute("user") UserAccount user, @RequestParam int postId, String likedBy) throws UserAccountNotFoundException, IncorrectOldPassword {
		likeServices.updateLikes(postId, likedBy);
		likeServices.getLikesCount(postId);
		List<Post> posts=postService.allPosts(user.getEmailId());
        return new ModelAndView("profilePage","posts",posts);
	}
	@RequestMapping("/delEmail")
    public ModelAndView delEmail(@RequestParam String emailId,int emailChatId) {
    	emailService.delEmail(emailId, emailChatId);
		return new ModelAndView("ShowAllEmails","success","Email deleted successfully");
    }
    @RequestMapping("/delAllEmail")
    public ModelAndView delAllEmail(@SessionAttribute("user") UserAccount user) throws NoMailsArePresentToDeleteException {
    	emailService.deleteAllMails(user.getEmailId());
		return new ModelAndView("showAllSentEmails","success","Emails deleted successfully Now Inbox is empty");
    }
    @RequestMapping("/delSentEmail")
    public ModelAndView delSentEmail(@RequestParam String emailId,int emailChatId) {
    	emailService.delSentEmail(emailId, emailChatId);
		return new ModelAndView("showAllSentEmails","success","Email deleted successfully");
    }
    @RequestMapping("/delAllSentEmail")
    public ModelAndView delAllSentEmail(@SessionAttribute("user") UserAccount user) throws NoMailsArePresentToDeleteException {
    	emailService.deleteAllSentMails(user.getEmailId());
		return new ModelAndView("showAllSentEmails","success","Emails deleted successfully Now sent box is empty");
    }
    @RequestMapping("/replyEmail")
	public ModelAndView replyEmail(@RequestParam String emailId,int emailChatId) throws UserAccountNotFoundException, UserNotAFriendException {
		return new ModelAndView("replyEmail", "email", emailService.getEmail(emailId, emailChatId));
	}
    @RequestMapping("/forwardEmail")
   	public ModelAndView forwardEmail(@RequestParam String emailId,int emailChatId) throws UserAccountNotFoundException, UserNotAFriendException {
   		return new ModelAndView("forwardEmail", "email", emailService.getEmail(emailId, emailChatId));
   	}
    @RequestMapping("/showOtherUserProfile")
    public ModelAndView showOtherUserProfile (@RequestParam String emailId ,@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException {
		return new ModelAndView("showOthersProfilePage","findUser",userService.searchUser(emailId));
    }
    @RequestMapping("/endSession")
    public ModelAndView endSession(@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException {
    	user=null;
		return new ModelAndView("loginPage","","");
    }
    @RequestMapping("/sendFriendRequest")
    public ModelAndView sendFriendRequest(@SessionAttribute("user") UserAccount user, @RequestParam String receiverEmailId) throws UserAccountNotFoundException, FriendRequestAlreadySentException {
    	friendServices.sendFriendRequest(user.getEmailId(), receiverEmailId);
    	UserAccount findUser=userService.searchUser(receiverEmailId);
		return new ModelAndView("showOthersProfilePage","findUser",findUser);
    }
    @RequestMapping("/showFriendRequest")
    public ModelAndView showFriendRequest(@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, FriendRequestAlreadySentException {
    	return new ModelAndView("friendRequestsPage","friendRequests",friendServices.showAllFriendRequest(user.getEmailId()));
    }
    @RequestMapping("/confirmFriendRequest")
    public ModelAndView confirmFriendRequest(@SessionAttribute("user") UserAccount user,  @RequestParam String senderEmailId ) throws UserAccountNotFoundException, FriendRequestAlreadySentException {
    	friendServices.confirmFriendRequest(senderEmailId, user.getEmailId());
    	return new ModelAndView("friendRequestsPage","success","Friend Request Accepted");
    }
    @RequestMapping("/declineFriendRequest")
    public ModelAndView declineFriendRequest(@SessionAttribute("user") UserAccount user,  @RequestParam String senderEmailId ) throws UserAccountNotFoundException, FriendRequestAlreadySentException {
    	friendServices.confirmFriendRequest(senderEmailId, user.getEmailId());
    	return new ModelAndView("friendRequestsPage","success","Friend Request Declined");
    }
    @RequestMapping("/showFriendList")
    public ModelAndView showFriendList(@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException {
		return new ModelAndView("friendsListPage","friends",friendServices.showAllFriends(user.getEmailId()));
    }
    @RequestMapping("/delFriend")
    public ModelAndView delFriend(@SessionAttribute("user") UserAccount user, @RequestParam String senderEmailId) {
    	friendServices.deleteFriendFromFriendList(user.getEmailId(),senderEmailId);
		return new ModelAndView("friendsListPage","success","Friend deleted successfully");
    }
    @RequestMapping("/postComment")
    public ModelAndView postComment( @RequestParam int postId, String emailId, String comment, @SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, FriendRequestAlreadySentException {
    	commentServices.saveComment(postId, user.getEmailId(), comment);
		return new ModelAndView("postPage","post",postService.showSinglePost(postId));
    }
    @RequestMapping("/showPost")
    public ModelAndView showPost(@SessionAttribute("user") UserAccount user, @RequestParam int postId) throws UserAccountNotFoundException, FriendRequestAlreadySentException {
		return new ModelAndView("postPage","post",postService.showSinglePost(postId));
    }
    @RequestMapping("/showBirthday")
    public ModelAndView showBirhtdays(@SessionAttribute("user") UserAccount user) throws UserAccountNotFoundException, FriendRequestAlreadySentException {
		return new ModelAndView("showBirthday","users",userService.findBirthday(user.getEmailId()));
    }
	  @RequestMapping("/deletePost")
	    public ModelAndView deletePost(@RequestParam int postId) throws UserAccountNotFoundException, FriendRequestAlreadySentException {
	    	postService.deletePost(postId);
			return new ModelAndView("profilePage","success","Post Deleted");
	    }
	  
}



