package BuilderServices;

import Entities.Ailment;
import Entities.Doctor;
import InputServices.UserInputService;

public class AilmentBuilderService {
    private UserInputService userInputService;

    public AilmentBuilderService(UserInputService userInputService) {
        this.userInputService = userInputService;
    }

//    public Ailment createAilment() {
//        String name = userInputService.getUserInput("What's the ailment's name?");
//        String index = userInputService.getUserInput("What's the startingIndex?");
//        int indexNum = Integer.parseInt(index);
////        Ailment ailment = new Ailment(indexNum, name);
//        return ailment;
//    }

}