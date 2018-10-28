package harjoitustyo.musiikkikokoelma.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import harjoitustyo.musiikkikokoelma.bean.Levy;
import harjoitustyo.musiikkikokoelma.dao.LevyDAO;


@Controller
@RequestMapping (value="/")
public class WelcomeController {

	@Inject
	private LevyDAO levyDao;
	
	public LevyDAO getLevyDao() {
		return levyDao;
	}

	public void setLevyDao(LevyDAO levyDao) {
		this.levyDao = levyDao;
	}
	
	// Levyjen Top 10
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getArtistiLista(Model model) {
		List<Levy> top10Levyt = levyDao.levytTop10();
		model.addAttribute("top10Levyt", top10Levyt);
		return "welcome";
	}
	
}
