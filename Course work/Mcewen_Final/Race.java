/********************************************************************************
 *                            Final Project TvH++                                *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS200                                                      *
 * ASSIGNMENT:       Final Project                                              *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  12/07/2019                                                 *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * Defines the general behaviors involved during the race                       *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This work is heavily          *
 * influenced by Kevin Ritter. He didn't help with the creation of the project  *
 * so much as I just straight jacked his code and modified it to fit my needs.  *
 *******************************************************************************/

import java.util.ArrayList;

public class Race {
    //region Attributes
    String KRitter = """
            \040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
            \040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                                  .....,////.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                             .*(%&&&&&&@@@@@%#//*....\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                         ..*(&@@@@@@@@@@@@@@@@@@@&&&&&(,.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                     .*#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%(,\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                  .*(%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%(.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                              ,/%@@@@@@@@@&&&&&&&%%&@@@@@@@@@@@@@&&@@@@@@@@@@@@@&%#/.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                            ./@@@@@@@@@&&&%%%%%%##%&&&&&@@@@@&&&&%%&@@@@@&&&&&&&&%%%#\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                          ./%@@@@@@@&&&&%%%%%###(#&%%#(&@@@&&&%%#%##&&&&&%#&%%%&%#(((*.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                      ./%@@@@@@&&&&%%%######((((((/////((///(#%##((#%%%#(((###%%##(//**,.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                     (%@@@@@@@&&&&%###((((((//////**********/(((((((##((///(((##((/*******\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                    *@@@@@@@@&&%%%%##(((((///////******,*****///((/(((/////////((/********,.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                 ./%@@@@@@@&&&%%%####(((////*//******,,**********/////********///*********,..\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                ,#@@@@@@@@&&%%%%#####(((///////*******************************//*********,,,..\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                               .&@@@@@@@@&%%%%%######(((//////*******************************************,,,,..\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                              ./@@@@@@@@@&%%%%%%####((((//////*/////************************************,,,,,,.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                             .(&@@@@@@@@@&&%%%%%%###((((//////*////*************************************,,,,,,,.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                            .#@@@@@@@@@@@&&&%%#######(((//////////*************************************,,,,,,,,..\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                            /&@@@@@@@@@@@@&&%%#%%%%##(((((////////********,,,,,,*****************,***,,,,,,,,,,...\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                           (&@@@@@@@@@@@@@&&&%%%%%%##(((((//////////*********************,,,,,,,**********,,,,,.....\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                           #@@@@@@@@@@@@@@@&&&%%%%%%##((((((////////////////////////*****************/*******,,......\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                          .&@@@@@@@@@@@@@@@@&&%%%%%%###((((((((((((((((((((///(((((((////////////////////******,,...,.\040\040\040\040\040\040\040\040\040\040\040\040\040
                         .(@@@@@@@@@@@@@@@@&&&%%%&&%%######%%%%&&&&&@@@@&&@@&&&&&%%####(((((((((#######((##((((//*,..,.\040\040\040\040\040\040\040\040\040\040\040\040
                         *&@@@@@@@@@@@@@@@@&%%%%&&&%%%%%%%&&@@@@@&&&&@@@@@@@@@@@@&&&%%###(((((#%%&&&&&&@@@@@@@&&&%(*...\040\040\040\040\040\040\040\040\040\040\040\040
                        .(@@@@@@@@@@@@@@@&&%%%%%&&&&&&&@&@@@@@@@@@@@@@@@@@&@@@@@@@@@@(//////(%&&@@@@@@@@@@@@@@@@@@(*,\040\040\040\040\040\040\040\040\040\040\040\040
                        .(@@@@@@@@@@@@@@@&&%%%&&&&&&&&&@@@@@@@@@@@&&&&@@@@@@@@@@@@&&&%%#//***//#&&&&&&&&&&&&&&&&@@@@&%#*\040\040\040\040\040\040\040\040\040\040\040
                        .(@@@@@@@@@@@@@@&&%%%%&@@@@@@@@@@@@@@&&&&%#(((#%&&&&&&&&&&&&&%##(///(((#&&&&&&&&&%(####%%%%&%%(,\040\040\040\040\040\040\040\040\040\040\040
                        *&@@@@@@@@@@@@@@&&&@@@@@@@@@@@@@@@@&&&&&&@&&&&&&&&&&&&&&&&&&&&&&&%#/((((&#%&&&&#####((((##(,\040\040\040\040\040\040\040\040\040\040\040
                       ,#@@@@@@@@@@@@@@@@@@@@@&&&@@@@@@@@@@@@@@@@@@@@@@@&@@@&%##%%%&&&&/****//&#%@@@@@@@@@&%%%#(/(/.    ,/\040\040\040\040\040
                      .(@@@@@@@@@@@@@@@@@@&&&&&&&&&@@@@@@@@@@@@@@@@@@@@&&&&&&%%%%%&@@@&%(//*****%@&&&@@@@@@@@@@@@@@&(/*,,#%#/,\040\040\040\040\040
                      .(@@@@@@@@@@@@@@@@@&&%%%%%%&&&&@@@&@@@@@@@@@@&&&%%%%%%#####%&&&&((/*****(&&%#%%%%&&&@@@@@@@@%((##,\040\040\040\040\040\040\040\040\040
                      .(&@@@@@@@@@@@@@@&&&&%%%#####%%&&@&&&&&%%#####(((/////(((((##%&#(((/*****(%%(((((((((((/**,....\040\040\040\040\040\040\040\040\040\040\040\040
                      .(&@@@@@@@@@@@@@&&&&&&&%##((#%%&&&&&%%%%%###((//****//((/(((#&&%##(((//***,*/#%*///////**,,,......\040\040\040\040\040\040\040\040\040\040\040
                      *#&&@@@@@@@@@@@@&&&&&&&&%#(##%%%%%%%%%%%%############%###%%&&%%####((//***,,*/(#(//((///*,..... ..\040\040\040\040\040\040\040\040\040\040\040
                      *%@@@@@@@@@@@@@@&&&%%%%%%%%%%%%%%######(((((////(((((((##%%%##%%####(//****,,,,,*///////////*****,,\040\040\040\040\040\040\040\040\040\040
                      *%@@@@@@@@@@@@@@&&&%%%%%#####%%%%%####((((((((((####((######%%%%%####(/****,,,,.,,*/((/////***,...\040\040\040\040\040\040\040\040\040\040\040
                      *#%&&&&@@@@@@@@@&&&%%%%#((((##%%%##((((((((((((//*****//(##%%%%%%%###(/******,,,,********//***,..\040\040\040\040\040\040\040\040\040\040\040\040
                      *#%%&&&&@@@@@@@&&&&%%%%#(((((####(((((((((//////******/(#%%%%%%%%####(//*****,,*((/////*****,,.\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                      *#%%%%&@@@@@@@@&&&&%%%%####((((((((((((((((///******//##%%%%####%####((/******,*(##(/////***,,..\040\040\040\040\040\040\040\040\040\040\040\040\040
                      *#%%%#%&@@@@@@@&&&%%%%%%%%########(((((((((///////(((#%%&%%%%%%%%%%##(/****/**,.,(%%(((////**,.\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                      *##%%#%&@@@@@@&&&&&%%%%%%%%##########(((((((////((###%%&&&&%%%%%%&&&%#((((((((/**/#%###(((//*,.\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                      *####%%%&@@@@@&&&&&%%%%%%%%%%%%%#######((((((((((##%%%%&@@@@@@@@@@@@@&&&%%&&&%&&%%%%%%####((//,,...\040\040\040\040\040\040\040\040\040\040
                      ./###%%%%&@@@@&&&&&&%%%%%%%%%%%%%%%##############%%%%%%&@@@@@@@@@@@@@@@@@@@@@@@&%%%%%%%####((/***,,\040\040\040\040\040\040\040\040\040\040
                       .*#%##%%&&&@@&&&&&&&%%%%%%%%%%%%%%%%%###########%%%%%%%&@@@@@@@@@@@@@@@@@@@@@@&%%%%%%%%%###((//**,\040\040\040\040\040\040\040\040\040\040
                         ,(%#((#&&@@&&&&&&&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&@@@@@@@@@@@@@@@@@&&%%%%%%%%%%%%%##(((//*\040\040\040\040\040\040\040\040\040\040
                           /((((&@@@&&&&&&&&&&%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%&&&@@@@@@@@@@@&&%%%%%%%%%%&&&%%%%#(((/*\040\040\040\040\040\040\040\040\040\040
                           *(((#&&@@@&&&&&&&&&%%%%%%%%%%%%%%%%%%%%&&%%%%%%%%%%%%%%#%%%%&&&&&&&%%###%%%%%%%%&&&&&&&%%(((/*\040\040\040\040\040\040\040\040\040\040
                           ./(((&&@@@&&&&&&&&&%%%%%%%%%%%%%%%%%%&&&&%%%&&&&&%%%%%#####%%%##(((((######%%%&&&&&&&&&%%(((/*\040\040\040\040\040\040\040\040\040\040
                            ,(((&&@@@&&&&&&&&&%%%%%%%%%%%%%%%%%%&&&%%%&&&&&&%%%%%%%%%%%%%%%##%%%%%%##(#%%%&&&&&&&&&%(((/,\040\040\040\040\040\040\040\040\040\040
                            ./%&@@@@@&&&&&&&&&%%%%%%%%%%%%%%%%%%%%%&&&@@@&&&&&&@@@@@@@&&&&&&&&&&&&@@@&%%&&&&&&&&%%##(((/.\040\040\040\040\040\040\040\040\040\040
                            .(&@@@@@@@@&&&&&&%%%%%%%%##%%%%#####%%%%&&@@@@@@@@&&%&%%%%/***//****%%&&&@@@@@@&&&&%%##((##/.\040\040\040\040\040\040\040\040\040\040
                            .(&@@@@@@@@@&&&&&&%%%%%%###%&&%%#(((##%%&&%@@@@@@@@%(%%(((/*,,*,,,,,/##(%@@@@@&&&%%%#(((##(,\040\040\040\040\040\040\040\040\040\040\040
                            ./&@@@@@@@@@@&&&&%%%%%%#####%&%%#(((((#%%%##&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&%%%%%%##((#%#*\040\040\040\040\040\040\040\040\040\040\040\040
                             ,#@@@@@@@@@@@&&&%%%%%######%%%%#(((((###%%###%&&&&&&&@@@@@@@@@@@@@@&&&@@@@&%%%%%%%#((##%(.\040\040\040\040\040\040\040\040\040\040\040\040
                              .(@@@@@@@@@@@&&&%%%%%######%%%##((((##########%%%%%%%%%%%&&&&&%%%%%%%%&&&%%%%%%%%#((#%#/.\040\040\040\040\040\040\040\040\040\040\040\040
                               ,@@@@@@@@@@@@&&%%%%%####(#%%%##((((#####((###%%%%%%%%%%%####%%%%%%%%%%%%%%#%%%%%####%/.\040\040\040\040\040\040\040\040\040\040\040\040\040
                                (&@@@@@@@@@@@@&%%%%##((((#%%%##((######((((#%%%%%%%##(((##((((###%%%%#####%%&%%####(\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                /&@@@@@@@@@@@@&&%%%###(((#%%%%#########((((###%%%%%%##((((######%%%%%%%%##%&&&&%%%#*\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                *%@@@@@@@@@@@@@&&%%##((((##%%%%###%%%#########%%%%%%%%%%%%%%%%%%%%%%%%%%##%&&&&&&%(,\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                 *#&@@@@@@@@@@@@@&&%######%%%%&%%%%%%########%%%%%%%%%%%%%%%%%%%%%%%%%%%##&&@@@&&%*\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                  ./%@@@@@@@@@@@@&&%%%###%%&&&&&&&%%%%#######%%%%%%%%%%%%%%%%%%%%%%%%%%##%&@@@@@%/\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                    ,&@@@@@@@@@@@@@&&&&&&&&&&&&&&&&&&&%#########%%%%%%%%%&&%&&&&%%%%%####%&@@@@#,\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                     #&@@@@@@@@@@@@@@&&&&&&&&@@&&&&&&&&%##########%%%%%%%%%%%%%%%%%######%@@@@@*\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                     ,#&@@@@@@@@@@@@@@@@&&&&&@@@@@@@&&&%%##((((((########%%%%%%%#####((#%&@@@@%\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                       ,/&@@@@@@@@@@@@@@@@@&@@@@@@@@@&&&%%%#(///(((((/(((((((((((((((##%&&@@&/\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                         ./%@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&%%(((((((((((((((((((((((##%%&&@@&/\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                            .(@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&%%%%%#################%%%&@@@&/.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                              #&@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&%%%#%%%%%%%%%%%%%&&&@@%/,\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                               ./%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&%%%%%%%%%%%%&&&@@@(,\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                  .%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@&&&&&&&&&@@@@@%.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                   ./%&@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#,\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                        .,*(%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@%/.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                             *#%@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                                ,*#%@@@@@@@@@@@@@@@@@@@@@@@%#*.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                                      ...,/#&@@&@&(((((*.\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
                                                                            ......\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
            \040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040
            \040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040\040

            """;



    private String event, winnerName, winningSpecies, timeColumn = "| %4s |";
    private StringBuilder dashes;
    private int length, winningTime, animalCount;
    public static ArrayList <Animal>  contestants;
    private StringBuilder eventLabel = new StringBuilder("");
    //endregion

    //region Constructors
    public Race(int length_, ArrayList<Animal> contestants_ )
    {
        this.length = length_;
        contestants = contestants_;
        this.animalCount = 1;
    }
    public Race(ArrayList<Animal> contestants_ )
    {
        this.length = 400;
        contestants = contestants_;
    }

    //endregion

    //region Getters & Setters
    public  void setEvent(String eventIn){this.event = eventIn;}

    public  String getEvent(){return this.event;}

    public  int getLength(){return this.length;}

    public void setLength(int length) {
        this.length = length;
    }

    public static void fightMe(ArrayList<Animal> contestants1, int fightState) {
        if (fightState == 1) {
            for (Animal animal : contestants1) {
                animal.setFightingAllowed(true);
            }
        }
        if (fightState == 0) {
            for (Animal animal : contestants1) {
                animal.setFightingAllowed(false);
            }
        }
    }

    //endregion

    //region Behaviors
    private void raceCard()
    {
        System.out.println(KRitter);
        this.dashes = new StringBuilder("+------+");
        System.out.println("--------------------------------------------------------------------------------------------------------");

        eventLabel.append(String.format("Event:  The %s ", contestants.get(0).getSpecies()));
        for(int i = 1; i < contestants.size(); i++)
        {
            eventLabel.append(String.format("v. the %s ", contestants.get(i).getSpecies()));
        }
        setEvent(eventLabel.toString());
        System.out.println(getEvent());
        System.out.println();
        System.out.println("Race distance (meters): " + getLength());
        System.out.println();
        for(Animal a: contestants)
        {
            System.out.println("Contestant " + animalCount + ": " + a.getName() + " the " + a.getSpecies());
            a.getIntro();
            System.out.println();
            this.animalCount++;
            this.dashes.append("-".repeat(Math.max(0, a.getColumnWidth()))).append("+");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Aaaaaaaand... we're OFF!!!");
        System.out.println(this.dashes);

        System.out.printf(this.timeColumn, " ");
        for(Animal a: contestants)
        {
            System.out.print(a.center(a.getName(), a.getColumnWidth()) + "|");
        }
        System.out.println();

        System.out.printf(this.timeColumn, " ");
        for(Animal a: contestants)
        {
            System.out.print(a.center(a.getSpecies(), a.getColumnWidth()) + "|");
        }
        System.out.println();

        System.out.printf(this.timeColumn, "Time");
        for(Animal a: contestants)
        {
            System.out.print(a.center(a.getColumnLabel(), a.getColumnWidth()) + "|");
        }
        System.out.println();
    }

    void runRace()
    {
        raceCard();

        double max = 0;

        do {

            boolean thatJerksWinning = false;

            for (int i = 1; i < contestants.size() ; i++) {
                int myLane = i;
                int theirLane = i-1;
                boolean itsTimeToRumble = contestants.get(myLane).isFightingAllowed();


                if(contestants.get(theirLane).getCurrentPosition() < contestants.get(myLane).getCurrentPosition()){
                    thatJerksWinning = true;
                }

                if( thatJerksWinning && itsTimeToRumble ){
                    Fight fight1 = new Fight();
                    fight1.fight(contestants.get(theirLane), contestants.get(myLane));
                }

            }

            System.out.printf(this.timeColumn, (contestants.get(0).getCurrentTime()));

            for(Animal a: contestants){
                if(a.getCurrentPosition()>=max){
                    max = a.getCurrentPosition();
                    this.winnerName = a.getName();
                    this.winningTime = a.getCurrentTime();
                    this.winningSpecies = a.getSpecies();
                }
                System.out.print(a.getRaceLine());
                a.updatePosition();
            }
            if(max>this.length)
            {
                break;
            }
            System.out.println();
        }
        while(max<this.length);
        System.out.println();
        System.out.println(this.dashes);
        // print race winner
        System.out.println("\nRace over in " + this.winningTime + " secs\n"
                + this.winnerName + " the " + this.winningSpecies+ " wins!!!");
    }

    //endregion

}