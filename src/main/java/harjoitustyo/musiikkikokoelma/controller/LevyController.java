package harjoitustyo.musiikkikokoelma.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import harjoitustyo.musiikkikokoelma.bean.Levy;
import harjoitustyo.musiikkikokoelma.bean.LevyImpl;
import harjoitustyo.musiikkikokoelma.bean.LevyArtisti;
import harjoitustyo.musiikkikokoelma.bean.LevyArtistiImpl;
import harjoitustyo.musiikkikokoelma.bean.LevyGenre;
import harjoitustyo.musiikkikokoelma.bean.LevyTyyppi;
import harjoitustyo.musiikkikokoelma.dao.LevyArtistiDAO;
import harjoitustyo.musiikkikokoelma.dao.LevyDAO;
import harjoitustyo.musiikkikokoelma.dao.LevyGenreDAO;
import harjoitustyo.musiikkikokoelma.dao.LevyTyyppiDAO;


@Controller
@RequestMapping (value="/levyt")
public class LevyController {

	@Inject
	private LevyDAO levyDao;
	
	public LevyDAO getLevyDao() {
		return levyDao;
	}

	public void setLevyDao(LevyDAO levyDao) {
		this.levyDao = levyDao;
	}
	
	@Inject
	private LevyGenreDAO levyGenreDao;
	
	public LevyGenreDAO getLevyGenreDao() {
		return levyGenreDao;
	}

	public void setLevyGenreDao(LevyGenreDAO levyGenreDao) {
		this.levyGenreDao = levyGenreDao;
	}
	
	@Inject
	private LevyTyyppiDAO levyTyyppiDao;
	
	public LevyTyyppiDAO getLevyTyyppiDao() {
		return levyTyyppiDao;
	}

	public void setLevyTyyppiDao(LevyTyyppiDAO levyTyyppiDao) {
		this.levyTyyppiDao = levyTyyppiDao;
	}
	
	@Inject
	private LevyArtistiDAO levyArtistiDao;
	
	public LevyArtistiDAO getLevyArtistiDao() {
		return levyArtistiDao;
	}

	public void setLevyArtistiDao(LevyArtistiDAO levyArtistiDao) {
		this.levyArtistiDao = levyArtistiDao;
	}
	
	// Levyjen listaus
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getLista(Model model) {
		List<Levy> levyt = levyDao.kaikkiLevyt();
		model.addAttribute("levyt", levyt);
		return "levy/levyLista";
	}
	
	// Levyn lisäys
	@RequestMapping(value="uusi", method=RequestMethod.GET)
	public String uusiLevy(Model model) {
		return "levy/uusiLevy";
	}
	
	@RequestMapping(value="uusi", method = RequestMethod.POST)
	public String talletaLevy(Model model,
							  @RequestParam(value = "otsikko", required = false) String otsikko,
							  @RequestParam(value = "artisti", required = false) String artisti) {
		if (otsikko == null || artisti == null) {
			return "levy/uusiLevy";
		} else {

		if(!levyArtistiDao.onkoLevyArtistia(artisti)) {
			LevyArtisti uusiLevyArtisti = new LevyArtistiImpl();
			uusiLevyArtisti.setNimi(artisti);
			levyArtistiDao.talletaLevyArtisti(uusiLevyArtisti);
		}
		
		LevyArtisti levyArtisti = levyArtistiDao.levyArtistinTiedotNimenMukaan(artisti);
		LevyGenre levyGenre = levyGenreDao.levyGenrenTiedot(1);
		LevyTyyppi levyTyyppi = levyTyyppiDao.levyTyypinTiedot(1);
		
		Levy levy = new LevyImpl();
		
		levy.setOtsikko(otsikko);
		levy.setLevyArtisti(levyArtisti);
		levy.setJulkaisuVuosi("0000");
		levy.setLevyGenre(levyGenre);
		levy.setArvosana(0);
		levy.setTunnus("-");
		levy.setLevyMaara(1);
		levy.setLevyTyyppi(levyTyyppi);
		levy.setLevyKunto(0);
		levy.setKansiKunto(0);
		levy.setMuutaTietoa("");

		levyDao.talletaLevy(levy);
		return "redirect:/levyt/levykuva?id=" + levy.getId() + "&u=1";
    }
	}
	
	// Levyn näyttö
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public String getLevy(@PathVariable Integer id, Model model) {
		Levy levy = levyDao.levynTiedot(id);
		List<LevyGenre> levyGenret = levyGenreDao.kaikkiGenret();
		List<LevyTyyppi> levyTyypit = levyTyyppiDao.kaikkiTyypit();
		model.addAttribute("levy", levy);
		model.addAttribute("levyGenret", levyGenret);
		model.addAttribute("levyTyypit", levyTyypit);
		return "levy/naytaLevy";
	}

	// Levyn muokkaus
	@RequestMapping(value="muokkaa", method = RequestMethod.POST)
	public String muokkaaLevy(Model model, 
							  @RequestParam("otsikko") String otsikko,
							  @RequestParam("artisti") String artisti,
							  @RequestParam("julkaisuVuosi") String julkaisuVuosi,
							  @RequestParam("genre") int genre,
							  @RequestParam("arvosana") int arvosana,
							  @RequestParam("tunnus") String tunnus,
							  @RequestParam("levyMaara") int levyMaara,
							  @RequestParam("tyyppi") int tyyppi,
							  @RequestParam("levyKunto") int levyKunto,
							  @RequestParam("kansiKunto") int kansiKunto,
							  @RequestParam("muutaTietoa") String muutaTietoa,
							  @RequestParam("id") int id) {
		
		if(!levyArtistiDao.onkoLevyArtistia(artisti)) {
			LevyArtisti uusiLevyArtisti = new LevyArtistiImpl();
			uusiLevyArtisti.setNimi(artisti);
			levyArtistiDao.talletaLevyArtisti(uusiLevyArtisti);
		}
		
		LevyArtisti levyArtisti = levyArtistiDao.levyArtistinTiedotNimenMukaan(artisti);
		LevyGenre levyGenre = levyGenreDao.levyGenrenTiedot(genre);
		LevyTyyppi levyTyyppi = levyTyyppiDao.levyTyypinTiedot(tyyppi);
		
		Levy levy = new LevyImpl();
		
		levy.setOtsikko(otsikko);
		levy.setLevyArtisti(levyArtisti);
		levy.setJulkaisuVuosi(julkaisuVuosi);
		levy.setLevyGenre(levyGenre);
		levy.setArvosana(arvosana);
		levy.setTunnus(tunnus);
		levy.setLevyMaara(levyMaara);
		levy.setLevyTyyppi(levyTyyppi);
		levy.setLevyKunto(levyKunto);
		levy.setKansiKunto(kansiKunto);
		levy.setMuutaTietoa(muutaTietoa);
		levy.setId(id);

		levyDao.muutaLevy(levy);
		return "redirect:/levyt/" + levy.getId();
	}
	
	// Levyn poisto
	@RequestMapping(value="poista", method = RequestMethod.POST)
	public String poistaLevy(Model model, @RequestParam(value = "id") int id) {
		
			levyDao.poistaLevy(id);
			return "redirect:/levyt";
    }
	
	
	@Autowired
	ServletContext context;
	
	// Levyn last.fm-tietojen lataus ja tallennus
	@RequestMapping(value="levykuva", method=RequestMethod.GET)
	public String levykuvatietoLataus(Model model, 
									  @RequestParam("id") int id, 
									  @RequestParam(value = "u", required = false) int u) 
	throws IOException {
		String polku = context.getRealPath("/resources/json");
	    File file = new File(polku + "/" + id);
	    if(!file.exists() || u == 1) { 
		    Levy levy = levyDao.levynTiedot(id);
		    String otsikko = levy.getOtsikko().replaceAll("\\s+","+");
		    LevyArtisti levyArtisti = levy.getLevyArtisti();
		    String artisti = levyArtisti.getNimi().replaceAll("\\s+","+");
			URL url = new URL("http://ws.audioscrobbler.com/2.0/?method=album.getinfo&api_key=LASTFM_API_KEY&artist=" + artisti + "&album=" + otsikko + "&format=json");
			FileUtils.copyURLToFile(url, file);
	    }
	    
		if(u == 1) {
			return "redirect:/levyt/" + id + "#muokkaa";
		} else {
			return "levy/json";
		}
	}
	
}
