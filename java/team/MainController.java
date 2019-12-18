package team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import team.Player.Builder;

@Controller 
@RequestMapping(path="/demo") 
public class MainController {
  
  @Autowired 
  private PlayerRepository playerRepository;
  
  @Autowired
  private ClubRepository clubRepository;
  
 
  
  
  @PostMapping(path="/add/player")
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String lastName, @RequestParam int age, @RequestParam String position, @RequestParam Long price, @RequestParam Club club ) {
    
//	Player n = new Player();
  
	Builder player = new Player.Builder()
            .setName(name)
 			.setLastName(lastName)
 			.setAge(age)
 			.setPosition(position)
			.setPrice(price)
			.setClub(club);
	
	playerRepository.save(player.build());
   System.out.println(club.getPlace());
    
    return "Saved";
  }
  

  @GetMapping(path="/player/all")
  public @ResponseBody Iterable<Player> getAllUsers() {
    
    return playerRepository.findAll();
  }
  
  @PostMapping(path="/add/club")
  public @ResponseBody String addNewClub (@RequestParam String club, @RequestParam String place, @RequestParam String website) {
    
	Club c = new Club();
    c.setClub(club);
    c.setPlace(place);
    c.setWebsite(website);
    clubRepository.save(c);
    return "Saved";
  }
  
  

  @GetMapping(path="/club/all")
  public @ResponseBody Iterable<Club> getAllClub() {
    
    return clubRepository.findAll();
  }
}