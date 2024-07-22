/**
 * 
 * I declare that this code was written by me, slenc. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Slency
 * Student ID: 22009748
 * Class: E63C
 * Date created: 2024-Jul-21 3:41:25 pm 
 * 
 */

package e66d.slency.fyp;

/**
 * @author slenc
 *
 */
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MemberDetailsService implements UserDetailsService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public MemberDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Member member = memberRepository.findByUsername(username);
		
		if (member == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MemberDetails(member);
	}
}


