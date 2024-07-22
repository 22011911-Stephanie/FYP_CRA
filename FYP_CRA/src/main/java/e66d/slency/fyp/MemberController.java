/**
 * 
 * I declare that this code was written by me, slenc. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Slency
 * Student ID: 22009748
 * Class: E63C
 * Date created: 2024-Jul-21 3:39:58 pm 
 * 
 */

package e66d.slency.fyp;

/**
 * @author slenc
 *
 */

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class MemberController {

    @Autowired
    private MemberRepository MemberRepository;

        @GetMapping("/members")
    public String viewMembers(Model model) {
        List<Member> listMembers = MemberRepository.findAll();
        model.addAttribute("listMembers", listMembers);
        return "view_members";
    }

    // Add member
    @GetMapping("/members/add")
    public String addMember(Model model) {
        model.addAttribute("member", new Member());
        return "add_member";
    }

    @PostMapping("/members/save")
    public String saveMember(RedirectAttributes redirectAttribute, @Valid Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("error");
            return "add_member";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);
        MemberRepository.save(member);

        redirectAttribute.addFlashAttribute("success", "Member registered!");
        return "redirect:/members";
    }

    // Edit member
	@GetMapping("/members/edit/{id}")
	public String editMember(@PathVariable("id") Integer id, Model model) {

		Member member = MemberRepository.getReferenceById(id);
		model.addAttribute("member", member);

		return "edit_member";
	}

	@PostMapping("/members/edit/{id}")
	public String saveUpdatedMember(@PathVariable("id") Integer id, Member member) {

		member.setPassword(MemberRepository.getReferenceById(id).getPassword());
		MemberRepository.save(member);
		return "redirect:/members";
	}

	// delete

	@GetMapping("/members/delete/{id}")
	public String deleteMember(@PathVariable("id") Integer id) {

		MemberRepository.deleteById(id);

		return "redirect:/members";
	}

}
