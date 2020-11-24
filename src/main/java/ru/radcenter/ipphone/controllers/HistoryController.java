package ru.radcenter.ipphone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.radcenter.ipphone.dto.HistorysDto;
import ru.radcenter.ipphone.services.AccountService;
import ru.radcenter.ipphone.services.HistoryService;
import ru.radcenter.ipphone.services.HistorysService;
import ru.radcenter.ipphone.services.CloudPhoneService;
import java.text.ParseException;


@Controller
final public class HistoryController {

    @Autowired
    private CloudPhoneService cloudPhoneService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private HistorysService historysService;

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model)  {
        return "index";
    }
    
    @RequestMapping(value = {"gethistory"}, method = RequestMethod.GET)
    public String getHistory(Model model) throws ParseException {
        //Сервис requestService загружает историю звонков и парсит ее
        HistorysDto historys = cloudPhoneService.mappingHistory();
        model.addAttribute("historys", historys);
        model.addAttribute("account_service", accountService);
        return "history_all";
    }

    @RequestMapping(value = {"save"}, method = RequestMethod.GET)
    public String saveHistory(Model model) throws ParseException {
        //Сервис requestService загружает историю звонков и парсит ее
        HistorysDto historys = cloudPhoneService.mappingHistory();
        historysService.save(historys);


        model.addAttribute("historys", historys);
        return "history_all";
    }

}
