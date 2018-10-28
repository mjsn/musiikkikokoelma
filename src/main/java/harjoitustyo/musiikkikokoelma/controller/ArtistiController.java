package harjoitustyo.musiikkikokoelma.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import harjoitustyo.musiikkikokoelma.bean.LevyArtisti;
import harjoitustyo.musiikkikokoelma.dao.LevyArtistiDAO;
import harjoitustyo.musiikkikokoelma.dao.LevyDAO;

@Controller
@RequestMapping (value="/artistit")
public class ArtistiController {

	@Inject
	private LevyDAO levyDao;
	
	public LevyDAO getLevyDao() {
		return levyDao;
	}

	public void setLevyDao(LevyDAO levyDao) {
		this.levyDao = levyDao;
	}
	
	@Inject
	private LevyArtistiDAO levyArtistiDao;
	
	public LevyArtistiDAO getLevyArtistiDao() {
		return levyArtistiDao;
	}

	public void setLevyArtistiDao(LevyArtistiDAO levyArtistiDao) {
		this.levyArtistiDao = levyArtistiDao;
	}
	
	// Artistien listaus
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getArtistiLista(Model model) {
		List<LevyArtisti> levyArtistit = levyArtistiDao.kaikkiLevyArtistit();
		model.addAttribute("levyArtistit", levyArtistit);
		return "artisti/artistiLista";
	}
	
}
