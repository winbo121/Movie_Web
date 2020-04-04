package gta.winbo.cali;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	private BoardService S;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void regist1() throws Exception{
		
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String reigst2(Model M,BoardVO V) throws Exception{
		S.insert(V);
		return "redirect:/board/listAll";
	}
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public void list(Model M) throws Exception{
		M.addAttribute("board",S.showAll());
	}
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void modify1(Model M,@RequestParam("bno") int bno)throws Exception{
		M.addAttribute("boardVO",S.read(bno));
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
		public String delete(Model M,@RequestParam("bno" )int bno,RedirectAttributes r)throws Exception{
			S.delete(bno);
			r.addFlashAttribute("msg","Success");
			return "redirect:/board/listAll";
		}
	@RequestMapping(value="/modify",method=RequestMethod.POST)
		public String modify2(Model M,BoardVO v,RedirectAttributes r)throws Exception{
			S.update(v);
			r.addFlashAttribute("msg","Success");
			
		
		return "redirect:/board/listAll";
		}
	
}
