package ua.aleks4ay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.aleks4ay.model.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    private String location;

//    @Autowired
//    private ServletContext context;

    public MainController() {
    }

    public String getContextValue(HttpServletRequest httprequest) {

        HttpSession htsession = httprequest.getSession();
        ServletContext servContext = htsession.getServletContext();
        String paramValue = (String)servContext.getInitParameter("paramName");
        return  paramValue;
    }

    @GetMapping("/")
    public String getStart() {
//        return "redirect:/tmc";
        return "hello";
    }

    @GetMapping("/ru")
    public String setRu() {
//        context.getInitParameter("param-name");
        this.location = "ru";
        System.out.println(location);
//        return "ru/home";
        return "redirect:home";
    }

    @GetMapping("/en")
    public String setEn() {
        this.location = "en";
        System.out.println(location);
        return "redirect:home";
//        return "en/home";
    }

    @GetMapping("/home")
//    @ResponseBody
    public ModelAndView getHome() {
        String url = location + "/home";
        ModelAndView modelAndView = new ModelAndView(url);
        modelAndView.addObject("language", location);
        return modelAndView;
    }

    @GetMapping("/newuser")
    public ModelAndView newUser() {
        String url = location + "/newuser";
        ModelAndView modelAndView = new ModelAndView(url);
        User user = new User();
        user.setLogin("Chukcha");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView doLogin() {
        String url = location + "/login";
        ModelAndView modelAndView = new ModelAndView(url);
        User user = new User();
        user.setLogin("Chukcha");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    /*  @GetMapping("/tmc")
    public ModelAndView mainView() {
        Timestamp start = DateConverter.getTimestampFromString(beginDay);
        Timestamp end = DateConverter.getTimestampFromString(endDay);
        BigTmcReader bigTmcReader = new BigTmcReader();
        List<BigTmc> allSortedTmc = bigTmcReader.getbigTmcListAfterSorting(start, end);

        if (! epicenter) {
            allSortedTmc = bigTmcReader.removeEpicenter(allSortedTmc);
        }

        int numberOfReports = bigTmcReader.getSizeOfDescription(allSortedTmc);

        ModelAndView modelAndView = new ModelAndView("all_tmc");

        modelAndView.addObject("testItems", allSortedTmc);
        modelAndView.addObject("numberOfReports", numberOfReports);
        modelAndView.addObject("beginStringDay", beginDay); //beginDay.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")
        modelAndView.addObject("endStringDay", endDay);
        modelAndView.addObject("period", new Period(beginDay, endDay, epicenter));

        return modelAndView;
    }*/

   /* @PostMapping("/tmcChange")
    public String changeDate(@ModelAttribute Period period, Model model) {
        beginDay = period.getBeginDay();
        endDay = period.getEndDay();
        return "redirect:/tmc";
    }*/

   /* @PostMapping("/epicenterChange")
    public String changeEpicenter() {
        epicenter = !epicenter;
        return "redirect:/tmc";
    }*/


/*    @GetMapping("/tmc/one/{id}")
    public ModelAndView viewOne(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("one_tmc");

        Timestamp start = DateConverter.getTimestampFromString(beginDay);
        Timestamp end = DateConverter.getTimestampFromString(endDay);
        BigTmcReader bigTmcReader = new BigTmcReader();

        List<BigTmc> allSortedTmc = bigTmcReader.getbigTmcListAfterSorting(start, end);
        BigTmc bigTmc = bigTmcReader.getOne(allSortedTmc, id);
        modelAndView.addObject("oneTmc", bigTmc);

        Timestamp minDateToShipment = bigTmc.getDescriptions().get(0).getOrder().getDateToFactory();

        ManufactureReader manufactureReader = new ManufactureReader();
        List<ManufactureTechno> manufactureTechnoList = manufactureReader.getById(id);
        manufactureReader.sortByDate(manufactureTechnoList);
        manufactureTechnoList = manufactureReader.removeWithOldDate(manufactureTechnoList, minDateToShipment);
        modelAndView.addObject("manufactures", manufactureTechnoList);

        List<ManufactureTechno> manufacturesAll = manufactureReader.getAll();

        Timestamp today = new Timestamp(getNowDate());
        List<ManufactureTechno> manuf1 = manufactureReader.restOnlyThisDate(manufacturesAll, today);
        modelAndView.addObject("manuf1", manuf1);

        Timestamp yesterday = new Timestamp(offset(getNowDate(), -1));
        List<ManufactureTechno> manuf2 = manufactureReader.restOnlyThisDate(manufacturesAll, yesterday);
        modelAndView.addObject("manuf2", manuf2);

        Timestamp yesterdayBefore2 = new Timestamp(offset(getNowDate(), -2));
        List<ManufactureTechno> manuf3 = manufactureReader.restOnlyThisDate(manufacturesAll, yesterdayBefore2);
        modelAndView.addObject("manuf3", manuf3);

        Timestamp yesterdayBefore3 = new Timestamp(offset(getNowDate(), -3));
        List<ManufactureTechno> manuf4 = manufactureReader.restOnlyThisDate(manufacturesAll, yesterdayBefore3);
        modelAndView.addObject("manuf4", manuf4);

        Timestamp yesterdayBefore4 = new Timestamp(offset(getNowDate(), -4));
        List<ManufactureTechno> manuf5 = manufactureReader.restOnlyThisDate(manufacturesAll, yesterdayBefore4);
        modelAndView.addObject("manuf5", manuf5);

        return modelAndView;
    }*/
}
