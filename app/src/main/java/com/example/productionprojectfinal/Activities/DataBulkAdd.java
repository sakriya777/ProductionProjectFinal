package com.example.productionprojectfinal.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.productionprojectfinal.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DataBulkAdd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_bulk_add);

        DatabaseReference refrence, dbref;
        refrence = FirebaseDatabase.getInstance().getReference();

        dbref = refrence.child("schoolcourse");

        String[] g6english = {"SOME BIRDS AND ANIMALS",
                "A BRAVE FEMALE PILOT",
                "WIT",
                "A FIELD TRIP",
                "A REAL HERO",
                "THE EARTH AND US",
                "THE WORLD CUP",
                "A LESSON FROM A GRASS CUTTER",
                "FEWA LAKE",
                "KITES",
                "AUTOMATED TELLER MACHINE",
                "GEORGE STEPHENSON",
                "THE GREAT GOOSE OF GOSAIKUNDA",
                "THE MUSICIANS OF ILAM",
                "PAPER BOY",
                "A POEM",
                "ENVIRONMENT POLLUTION",
                "ALL POEMS OF 4, 6 AND 10"};

        String[] g6mathematics = {"LINES AND ANGLES",
                "TRIANGLE, QUADRILATERAL, AND POLYGON",
                "COORDINATES",
                "PERIMETER, AREA, AND VOLUME",
                "TRANSFORMATION, SYMMETRY AND TESSELLATION",
                "SET",
                "WHOLE NUMBERS",
                "INTEGERS",
                "RATIONAL NUMBERS",
                "FRACTION AND DECIMAL",
                "RATIO, PROPORTION AND PERCENTAGE",
                "PROFIT AND LOSS",
                "UNITARY METHOD",
                "SIMPLE INTEREST",
                "STATISTICS",
                "ALGEBRAIC EXPRESSIONS",
                "EQUATION, INEQUALITY AND GRAPH"};

        String[] g6nepali = {"????????????",
                "?????????????????? ???????????? ??????????????? ?????????????????????",
                "????????????????????? ?????????????????????",
                "???????????????????????? ???????????????",
                "??????????????? ??????????????????",
                "????????????",
                "???????????? ??? ????????????",
                "???????????????????????? ??????????????????",
                "????????????????????? ????????????",
                "?????????????????????????????? ???????????????",
                "??????????????????????????????????????? ?????????????????? ???????????? (????????????????????????)",
                "?????????????????????????????? ?????????",
                "????????????????????????????????? ?????????????????????",
                "????????? ??????????????????",
                "??????????????????????????? ???????????????",
                "?????????????????? ??????????????????",
                "??????????????? ?????? ???????????????",
                "??????????????? ?????????????????????",
                "????????????????????????????????????????????? ??????????????????",
                "????????????????????????????????? ?????????????????????"
        };

        String[] g6sciene = {"MEASUREMENT",
                "FORCE AND MOTION",
                "SIMPLE MACHINE",
                "HEAT",
                "LIGHT",
                "SOUND",
                "MAGNETISM",
                "ELECTRICITY",
                "MATTER",
                "MIXTURE",
                "SOME USEFUL CHEMICALS",
                "AIR",
                "METALS AND NON-METALS",
                "LIVING BEINGS",
                "CELL STRUCTURE",
                "LIFE PROCESS",
                "STRUCTURE OF EARTH",
                "WEATHER",
                "SOLAR SYSTEM",
                "ENVIRONMENT AND ITS COMPONENTS",
                "ENVIRONMENTAL DEGRADATION AND ITS CONSERVATION",
                "ENVIRONMENT AND IT'S SUSTAINABLE DEVELOPMENT"

        };

        String[] g6social = {"WE AND OUR COMMUNITY",
                "OUR SOCIAL NORMS AND VALUES",
                "SOCIAL PROBLEMS & SOLUTIONS",
                "CIVIC SENSE",
                "OUR EARTH",
                "OUR HISTORY",
                "OUR ECONOMIC ACTIVITIES",
                "OUR INTERNATIONAL RELATIONSHIP AND SUPPORT",
                "INTRODUCTION TO POPULATION AND ITS CONDITIONS",
                "POPULATION GROWTH AND ITS MANAGEMENT"

        };

        String[] g7english = {"PLACES TO VISIT", "TRAVEL EXCITEMENT", "LOCATIONS AND POSITIONS", "FAMOUS MONUMENTS", "WISHES AND CHOICES", "FAMOUS PEOPLE", "FESTIVALS IN NEPAL", "SEE THE DIFFERENCE", "A PLAN FOR A VISIT", "THE ENDANGERED SPECIES", "OUR VALUES", "GAMES AND SPORTS", "INSTRUCTIONS", "EXCURSION TO THE ZOO", "NARRATING EVENTS"};
        String[] g7mathematics = {"1.LINE AND ANGLE", "2.TRIANGLES", "3.SIMILARITY AND CONGRUENCY", "4.CIRCLE", "5.SOLID FIGURES", "6.CO-ORDINATE", "7.PERIMETER AND AREA", "8.TRANSFORMATION", "9.SYMMETRY AND TESSELLATION", "10.BEARING AND SCALING", "11.SET", "12.WHOLE NUMBER", "13.INTEGER", "14.RATIONAL NUMBER", "15.IRRATIONAL NUMBER", "16.FRACTION & DECIMAL", "17.RATIO, PROPORTION & PERCENT", "18.PROFIT & LOSS", "19.UNITARY METHOD", "20.SIMPLE INTEREST", "21.STATISTICS", "22.ALGEBRAIC EXPRESSION", "23.INDICES", "24.EQUATION, INEQUALITY AND LINE GRAPH"};
        String[] g7nepali = {"1.???????????????", "2.????????????????????? ???????????????????????? ??????????????????", "3.?????????????????????????????? ?????????????????? ????????????: ??????", "4.????????????????????? ??????????????????", "5.?????????????????????????????? ?????????", "6.???????????? ???????????? ???????????? ????????????", "7.????????? ???????????? ?????????", "8.??????????????????????????? ?????????????????? ????????????: ???????????????", "9.????????????????????? ????????????", "10.????????? ????????????????????? ????????????", "11.?????????????????????????????? ??????????????? ????????????????????? ?????????", "12.????????????????????? ????????????", "13.????????????????????????????????? ?????????????????????", "14.?????????????????????????????? ?????????", "15.??? ??????????????? ??????????????? ?????????", "16.????????? ??? ??????????????????", "18.???????????? ????????????????????????????????? ?????????????????????", "19.??????????????????", "20.????????????????????? ????????????????????? ???????????????????????????", "21.?????????????????? ?????????"};
        String[] g7sciene = {"1.MEASUREMENT", "2.FORCE AND MOTION", "3.SIMPLE MACHINE", "4.PRESSURE", "5.ENERGY, WORK AND POWER", "6.HEAT", "7.LIGHT", "8.SOUND", "9.MAGNET", "10.ELECTRICITY", "11.MATTER", "12.MIXTURE", "13.METAL AND NON-METAL", "14.SOME USEFUL CHEMICALS", "15.LIVING BEINGS", "16.CELL AND TISSUE", "17.LIFE PROCESS", "18.STRUCTURE OF EARTH", "19.WEATHER AND CLIMATE", "20.EARTH AND SPACE", "21.ENVIRONMENT AND ITS BALANCE", "22.ENVIRONMENTAL DEGRADATION AND ITS CONSERVATION", "23.ENVIRONMENT AND SUSTAINABLE DEVELOPMENT"};
        String[] g7social = {"1.???????????? ??? ?????????????????? ????????????", "2.?????????????????? ????????????????????? ??????????????? ??? ?????????????????????", "3.????????????????????? ?????????????????? ??? ??????????????????", "4.?????????????????? ???????????????", "5.?????????????????? ??????????????????", "6.?????????????????? ????????????", "7.?????????????????? ????????????????????? ??????????????????????????????", "8.?????????????????? ????????????????????????????????????????????? ????????????????????? ??? ???????????????", "9.?????????????????????????????? ???????????????????????? ??????????????? ??? ???????????????????????????????????? ??????????????????", "10.?????????????????????????????? ????????????????????? ??? ??????????????????????????????"};

        String[] g8english = {"TRAVELOGUE", "AN EXPEDITION", "BUSSINESS AND COMMERCE", "BIOGRAPHY", "FESTIVALS", "TECHNOLOGY", "JOURNALISM", "DANGERS OF JUNK FOOD", "MORAL STORIES", "HABITS AND BEHAVIOUR", "GAMES AND SPORTS", "DISTRICT PROFILE", "CHILDHOOD MEMORIES", "GRAPHS AND CHARTS", "LINCOLN'S LETTER", "FAIRY TALES", "FORMS AND CHEQUES", "DICTIONARY USE"};
        String[] g8mathematics = {"1. SET", "2. WHOLE NUMBER", "3. SQUARE ROOT AND CUBE ROOT", "4. RATIONALIZATION", "5. RATIONAL AND IRRATIONAL NUMBERS", "6. RATIO, PROPORTION AND PERCENTAGE", "7. PROFIT AND LOSS", "8. UNITARY METHOD", "9. SIMPLE INTEREST", "10. STATISTICS", "11. ALGEBRAIC EXPRESSION", "12. EQUATION, INEQUALITY AND GRAPH", "13. ANGLES AND PARALLEL LINES", "15. REGULAR POLYGON", "16. CONGRUENT AND SIMILAR TRIANGLES", "18. PERIMETER AND AREA OF TRIANGLE AND QUADRILATERAL", "19. CIRCLE", "20. CYLINDER AND PRISM", "21. TRANSFORMATION", "22. BEARING AND SCALE DRAWING"};
        String[] g8nepali = {"1. ???????????????", "2. ??????????????? ", "3. ??????????????????????????? ????????????", "4. ?????????????????????????????????", "5. ?????????????????? ????????????", "6. ?????????????????????", "7. ????????? ??? ????????????", "8. ??????????????????????????? ???????????? ???????????????", "9. ????????????????????? ??? ?????????????????????", "10. ???????????? ????????????", "11. ?????????????????? ????????????", "12. ???????????? ??????", "14. ?????????????????????????????? ????????????????????????????????? ???????????????", "16. ??????????????????????????? ??? ????????????????????????", "17. ???????????? ???????????? ???????????? - ??????????????????", "18. ?????????????????????", "19. ???????????? ??? ????????????????????? ?????????", "20. ?????????????????? ????????????????????????", "21. ?????? ????????????????????? ??????????????????", "22. ?????????????????????????????? - ????????? ????????????"};
        String[] g8sciene = {"1. MEASUREMENT", "2. VELOCITY AND ACCELERATION", "3. SIMPLE MACHINES", "4. PRESSURE", "5. ENERGY, WORK AND POWER", "6. HEAT", "7. LIGHT", "8. SOUND", "9. MAGNETISM", "10. ELECTRICITY", "11. MATTER", "12. MIXTURE", "13. METALS AND NON - METALS", "14. ACID, BASE AND SALT", "15. SOME USEFUL CHEMICALS", "16. LIVING BEINGS", "17. CELL AND TISSUE", "18. LIFE PROCESSES", "19. STRUCTURE OF EARTH", "20. WEATHER AND CLIMATE", "21. EARTH AND UNIVERSE", "22. ENVIRONMENT AND ITS BALANCE", "23. ENVIRONMENT DEGRADATION AND ITS CONSERVATION", "24. ENVIRONMENT AND SUSTAINABLE DEVELOPMENT"};
        String[] g8social = {"1. ????????????, ?????????????????? ?????????????????? ??? ?????????????????????", "2. ?????????????????? ????????????????????? ??????????????? ??? ?????????????????????", "3. ????????????????????? ?????????????????? ??? ??????????????????", "4. ?????????????????? ???????????????", "5. ?????????????????? ??????????????????", "6. ?????????????????? ????????????", "7. ?????????????????? ????????????????????? ??????????????????????????????", "8. ?????????????????? ????????????????????????????????????????????? ????????????????????? ??? ???????????????", "9. ???????????????????????????????????? ??????????????? ??? ???????????????????????????????????? ??????????????????", "10. ?????????????????????????????? ????????????????????? ??? ??????????????????????????????"};

        String[] g9english = {"MAKING PLANS AND EXPRESSING INTENTIONS", "SUGGESTING , ADVICING AND PERSUADING", "MAKING REQUEST AND RESPONDING TO THEM", "EXPRESSING CONDOLENCE AND SYMPATHY", "CRITICIZING AND EXPRESSING DEGREES OF PROBABILITY", "MAKING OFFERS AND RESPOND TO THEM", "GIVING INSTRUCTION AND DESCRIBING PURPOSE", "TALKING ABOUT PAST", "GIVING DIRECTION", "INTERPRETING GRAPHS, CHARTS AND DIAGRAMS", "DESCRIBING AN OBJECT OR A PLACE", "EXPRESSING ABILITY AND INABILITY", "EXPRESSING CONGRATULATIONS", "ASKING FOR PERMISSION", "APOLOGIZING AND RESPONDING TO THEM", "CREATIVE WRITING"};
        String[] g9mathematics = {"1. SETS", "2. PROFIT AND LOSS", "3. COMMISSION AND TAX", "4. HOME ARITHMETIC", "5. MENSURATION ( AREA)", "6. AREA AND VOLUME OF SOLID OBJECTS", "7. HCF AND LCM", "8. INDICES", "9. RATIO AND PROPORTION", "10. LINEAR EQUATION", "11. QUADRATIC EQUATION", "12. TRIANGLES", "13. PARALLELOGRAM", "14. CONSTRUCTION", "15. SIMILARITY", "16. CIRCLE", "17. TRIGONOMETRY", "18. STATISTIC", "19. PROBABILITY"};
        String[] g9nepali = {"1. ?????????????????? ?????????", "2. ?????????????????? ???????????? ???????????????", "3. ??????????????????????????? ?????????????????? ??????????????????", "4. ??? ????????? ????????? ?", "5. ???????????? ????????????????????? ????????????????????? ????????????????????? ?????????????????????", "6. ?????????????????????????????? ????????????", "7. ??????????????????", "8. ??????????????? ???????????????", "9. ??????????????? ????????????", "10. ??????????????????????????? ????????? ?????????", "11. ?????????????????? ???????????????", "12. ?????? ????????? ????????????", "13. ?????? ?????? ?????????????????????????????????", "14. ??????????????? ???????????????", "15. ???????????????????????????", "16. ???????????????????????? ??????????????????"};
        String[] g9sciene = {"1. MEASURMENT", "2. FORCE", "3. SIMPLE MACHINE", "4. WORK , ENERGY AND POWER", "5. LIGHT", "6. SOUND", "7. CURRENT ELECTRICITY AND MAGNETISM", "8. CLASSIFICATION OF ELEMENTS", "9. CHEMICAL REACTION", "10. SOLUBILITY", "11. SOME GASES", "12. METALS", "13. CARBON AND ITS COMPOUNDS", "14. WATER", "15. CHEMICAL FERTILIZER USED IN AGRICULTURE", "16. CLASSIFICATION OF PLANTS AND ANIMALS", "17. ADAPTATION OF ORGANISM", "18. SYSTEM", "19. SENSE ORGANS", "20. EVOLUTION", "21. NATURE AND ENVIRONMENT", "22. NATURAL HAZARD", "23. GREEN HOUSE", "24. THE EARTH IN THE UNIVERSE"};
        String[] g9social = {"2. ??????????????? ??? ????????????????????? ?????????????????????????????????", "5. ?????????????????? ???????????????", "6. ?????????????????? ??????????????????", "8. ?????????????????? ??????????????????????????????"};

        String[] g10english = {"UNIT 1: GIVING WITHHOLDING AND REPORTING PERMISSION", "UNIT 2: REPORTING STATEMENT", "UNIT 3: REPORTING QUESTIONS", "UNIT 4: REPORTING COMMANDS", "UNIT 5: GIVING ADVICE AND WARNINGS", "UNIT 6: EXPRESSING CONDITIONS", "UNIT 7: EXPRESSING CONDITIONS", "UNIT 8: ASKING FOR REASONS, PURPOSES AND THEIR RESPONSES", "UNIT 9: EXPRESSING UNEXPECTED RESULTS", "UNIT 10: DESCRIBING EVENTS", "UNIT 11: EXPRESSING PREFERENCES", "UNIT 12: TALKING ABOUT PERSONAL EXPERIENCE", "UNIT 13: TALKING ABOUT THE PAST (I) : NARRATING PAST EVENTS", "UNIT 14: TALKING ABOUT THE PAST (II): INTERRUPTED CONTINUOUS ACTION", "UNIT 15: TALKING ABOUT THE PAST (III): COMPARING PAST AND PRESENT", "UNIT 16: CONFIRMING AND DENYING", "UNIT 17: AGREEING AND DISAGREEING", "UNIT 18: INDICATING TIME AND MOTIONS", "UNIT 19: INTERPRETING TABLES AND CHARTS GLOSSARY",};
        String[] g10mathematics = {"1. SETS", "2. TAX AND MONEY EXCHANGE", "3. COMPOUND INTEREST", "4. POPULATION GROWTH AND COMPOUND DEPRECIATION", "5. PLANE SURFACE", "6. CYLINDER AND SPHERE", "7. PRISM AND PYRAMID", "8. H.C.F AND L.C.M", "9. RADICAL AND SURDS", "10. INDICES", "11. ALGEBRAIC FRACTION", "12. EQUATIONS", "13. TRIANGLES AND QUADRILATERAL", "14. CONSTRUCTION", "15. CIRCLE", "16. TRIGNOMETRY", "17. STATISTICS", "18. PROBABILITY"};
        String[] g10nepali = {"1. ???????????????????????? (?????????)", "2. ?????????????????????????????? (???????????????)", "3. ?????????????????? ???????????? (???????????????)", "4. ????????????????????? (??????????????????)", "5. ??? ????????? ??????????????? (?????????????????????)", "6. ??????????????????????????? ???????????? (????????????)", "7. ?????????????????????????????? ( ?????????)", "8. ??????????????? (???????????????)", "9. ????????????????????? ???????????????????????? (??????????????????)", "10. ????????????????????????????????????????????? ????????????????????????????????????????????? ????????? (????????????????????????)", "11. ????????????????????????????????? (?????????)", "12. ?????????????????? ?????????????????? (???????????????)", "13. ?????? ??????????????? ( ??????????????????)", "14. ??? ????????? ????????????????????? ?????? (???????????????)", "15. ???????????? (????????????????????????)", "16. ??????????????? ???????????????????????????????????? ???????????? (?????????)"};
        String[] g10sciene = {"1. FORCE", "2. PRESSURE", "3. ENERGY", "4. HEAT", "5. LIGHT", "6. CURRENT ELECTRICITY AND MAGNETISM", "7. CLASSIFICATION OF ELEMENTS", "8. CHEMICAL REACTION", "9. ACID, BASE AND SALT", "10. SOME GASES", "11. METALS", "12. HYDROCARBON AND ITS COMPOUNDS", "13. MATERIAL USED IN DAILY LIFE", "14. INVERTEBRATES", "15. NERVOUS AND GLANDULAR SYSTEM", "16. BLOOD CIRCULATION IN HUMAN BODY", "17. CHROMOSOME AND SEX DETERMINATION", "18. REPRODUCTION", "19. HEREDITY", "20. ENVIRONMENTAL POLLUTION AND MANAGEMENT", "21. HISTORY OF THE EARTH", "22. CLIMATE CHANGE AND ATMOSPHERE", "23. THE EARTH IN THE UNIVERSE"};
        String[] g10social = {"1. WE, OUR COMMUNITY AND NATION", "2. DEVELOPMENT AND ITS PREREQUISITES", "3. OUR SOCIAL VALUES AND NORMS"};

        String[] g11english = {};
        String[] g11mathematics = {};
        String[] g11nepali = {};
        String[] g11sciene = {};
        String[] g11social = {};

        String[] g12english = {};
        String[] g12mathematics = {};
        String[] g12nepali = {};
        String[] g12sciene = {};
        String[] g12social = {};

        String[] g6socialchap1 = {"Community and Society", "Origin and Formation of Society", "Our VDC And its Functions", "Our Municipality and its Functions", "Our Infrastructure Of Development:Education", "Our Infrastructure of Development:Health"};
        String[] g6socialchap2 = {"Our Festivals", "Our National Pride", "Unity in Diversity", "Our Cultural Heritage", "Our Religious Heritages", "Jaya Prithivi Bahadur Singh", "Tulsi Meher Shrestha"};
        String[] g6socialchap3 = {"Causes and Solution of Social problems", "Social Problems", "Social Evils", "Social Discrimination", "Feel The Problem of Others", "Sustainable Peace"};
        String[] g6socialchap4 = {"Our Constitution", "Introduction to Citizen", "Rights of a Citizen", "The Traffic Rules", "Duties of Citizens", "Nation and Nationality", "Federal Democratic Republic"};
        String[] g6socialchap5 = {"Introduction to Earth", "Latitudes and Longitudes", "Location, Size and Boundary of Nepal", "Topography and Climate of Nepal", "Social life of Nepal", "Map Work", "Continent of Asia", "Climate Change", "Disaster Management",};
        String[] g6socialchap6 = {"Origin of Kathmandu Valley", "Sinja Valley", "Political Condition of Ancient Nepal", "Social Structure of Ancient Nepal", "Economic Activities of Ancient Nepal", "Art and Culture of Ancient Nepal", "The Indus Valley Civilization", "The Nile Valley Civilization"};
        String[] g6socialchap7 = {"Introduction to Our Economic Activities", "Agricultural Activities of Nepal", "Present State of Agriculture in Nepal", "Service as an Important Economic Activity", "Present State Of Service Sectors And Its Importance"};
        String[] g6socialchap8 = {"Introduction to International Relation and Cooperation", "South Asian Association for Regional Cooperation (SAARC)", "Objectives of SAARC", "Importance Of SAARC For Nepal", "Current Affairs of the World"};
        String[] g6socialchap9 = {"Introduction and Importance of Population", "Factors of Population Change", "Relation of Population with other Subjects", "Size and Change of Population", "Composition and Distribution of Population"};
        String[] g6socialchap10 = {"Population Growth and its Effect", "Introduction and Importance of Population Management", "Problems of Population Management", "Role of Governmental And Non-Governmental Organization in Population Management", "Measures of Population Management"};


        String[] subjects = {"english", "mathematics", "nepali", "science", "social"};

        String[] grades = {"grade6", "grade7", "grade8", "grade9", "grade10"};

        for (String grade : grades) {
            if (grade.equals("grade6")) {
                for (String sub : subjects) {
                    if (sub.equals("english")) {
                        int num = 1;
                        for (String chap : g6english) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("mathematics")) {
                        int num = 1;
                        for (String chap : g6mathematics) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("nepali")) {
                        int num = 1;
                        for (String chap : g6nepali) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("science")) {
                        int num = 1;
                        for (String chap : g6sciene) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("social")) {
                        int num = 1;
                        for (String chap : g6social) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            int lesson = 1;
                            if (num == 1) {
                                for (String lesso : g6socialchap1) {
                                    if (lesson == 1) {
                                        String lesson1 = "As we know that, all of us live in a family where many families live together in a place it is called a neighborhood. In the same way, a group of family or people sharing a common understanding and often the same language, manners, tradition and law with each other is known as a community. We can not live alone because human beings are social animals. When we live in a community we can help each other to satisfy our needs which make our life comfortable and easier. Communities play a major role in the developments of societies and nations. They provide a program for people to come and exchange various ideas and experiences.Here, people of different occupation lives in a community some of them are pilot, teachers, doctors , engineers , farmers, tailors etc . Farmers work in the field and provide food for us, tailors make our dressed,Teachers give us the education whereas doctors check us when we are sick .In such way, we can help and co-operate with each other.Because of this, we can feel safer in a community than living alone . So, community plays an essential, role in our daily life . Simply from a community, we can learn a different culture, art , music , history, etc which are developed in the community. The community and its environment greatly influenced Language thought, and behaviors of the children. Community plays a major role in developing the mind of a child .Here.The government also plays a role in our life which helps to fulfill our demands and we can preserve our interest and rights.\n Society means the number of people living in a country, by honoring its laws and customs .On the basis of geography , religion , culture etc is formed by society. People lives in a society to satisfy each other needs.And also it consists of the people of different races, religions ages and classes .There are some similarity and difference between community and society .Community means a group of people living commonly, having some character in common but Society means the number of people living in a region, by accepting its laws and customs. The main difference between a community and a society is that a community is bound to a specific geographic location, but a society can be made up of the geographical boundary. community share common traits or interests whereas society honor and obey the pertinent laws and customs .Feeling of unity , attachment to each other, accountability , security , mutual understanding , etc the similarities found both in community and society .So community and society are equally essential for us.";
                                        HashMap<String, String> lessons = new HashMap<>();
                                        lessons.put("name", lesso);
                                        lessons.put("number", String.valueOf(lesson));
                                        lessons.put("lesson", "lesson" + lesson);
                                        lessons.put("content", lesson1);
                                        dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    }
                                    if (lesson == 2) {
                                        String lesson1 = "Here, it is clear that society begins to make progress since its beginning. Where it took a long period to take shape. There are several stages of development of society. They are given below:\n" +
                                                "\n" +
                                                "Hunting age\n" +
                                                "\n" +
                                                "In a backward society, like a wild animal human beings used to live in a forest. They used to live in\n" +
                                                "\n" +
                                                "caves at that time and for their foods they hunt animals. Which was not easy to hunt wild animals and even they had no concept of living in a house. Thatswhy, it was called Stone Age or Hunting age.\n" +
                                                "\n" +
                                                "Animal rearing age\n" +
                                                "\n" +
                                                "It was not easy to get animals to hunt. They had to wander far and wide in a course of hunting. Slowly as a time spend, rearing animals had been developed in them. So, instead of killing them they start to save animals. Now they had a less problem in getting food.And it was the Animal-rearing age. ";
                                        HashMap<String, String> lessons = new HashMap<>();
                                        lessons.put("name", lesso);
                                        lessons.put("number", String.valueOf(lesson));
                                        lessons.put("lesson", "lesson" + lesson);
                                        lessons.put("content", lesson1);
                                        dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    }
                                    if (lesson == 3) {
                                        String lesson1 = "Our country Nepal is divided into five development region, 14 zones and 75 districts. All of them are a\n" +

                                                "\n" +
                                                "A political division which is made to develop all part of the country equally. Here, in our country ???Village Development Committee is the smallest political system of our country which is created by the joining two or more than two villages to develop the village of our country. In each VDC there are 9 wards.The local body of a country is VDC.\n" +
                                                "\n" +
                                                "There is the provision of the composition of VDC in Local Self-Government Act 2055 BS . According to this act, there are 13 members altogether in the VDC. One from each Ward a VDC has composed one chairperson, one vice-chairperson and nine wards member. The vectors of that VDC are elected the chairperson and vice-chairperson. Here to be a vector, one must attain the age of 18 or above and resident of the concerned VDC. The respective wards of the VDC are elected the nine ward members. To be a candidate for the posts of chairperson, vice-chairperson and ward members the following qualification are needed: ";
                                        HashMap<String, String> lessons = new HashMap<>();
                                        lessons.put("name", lesso);
                                        lessons.put("number", String.valueOf(lesson));
                                        lessons.put("lesson", "lesson" + lesson);
                                        lessons.put("content", lesson1);
                                        dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    }if (lesson == 4) {
                                        String lesson1 = "We have already studied that to develop village areas VDCs are formed . In the same way, to develop urban areas municipality plays a vital role . A municipality is composed of a Mayor, Deputy Mayor, and nine or more ward chairpersons . Mayor is called the head of the municipality . For the term of five years, all the adult citizen of the municipality areas are elected. Our country has 99 municipalities at present.\n" +
                                                "Types of Municipality\n" +
                                                "\n" +
                                                "Into three division municipalities in Nepal are classify on the basis of population , urban facilities and income of a city . They are\n" +
                                                "\n" +
                                                "    Municipality\n" +
                                                "    Sub-Metropolitan city\n" +
                                                "    Metropolitan city\n" +
                                                "\n" +
                                                "Municipality\n" +
                                                "\n" +
                                                "Government of Nepal can declare any urban area as a municipality which possesses the following requirements :\n" +
                                                "\n" +
                                                "    A minimum population of 20,000 ( for hilly regions 10000)\n" +
                                                "    A minimum annual income of Rs. 5 lakhs\n" +
                                                "    A semi-Urban area possessing electricity, transportation, drinking water, communication and similar other basic facilities.\n" +
                                                "\n" +
                                                "Sub-Metropolitan City\n" +
                                                "\n" +
                                                "A Sub-Metropolis should possess the following requirements:\n" +
                                                "\n" +
                                                "    A minimum population of 1 lakh\n" +
                                                "    Minimum Annual Income of 10 crores\n" +
                                                "    Facilities like electricity, drinking water, and communication\n" +
                                                "    Main Road of a city is pitched\n" +
                                                "    Facility of higher education and health service\n" +
                                                "    Have minimum physical facilities for conducting national & international sports and games\n" +
                                                "    Facilities like gardens, parks & city hall be available\n" +
                                                "    Has already become Metropolis\n" +
                                                "\n" +
                                                "Metropolitan City\n" +
                                                "\n" +
                                                "A metropolitan city should possess the following requirements:\n" +
                                                "\n" +
                                                "    A minimum population of 3 lakhs\n" +
                                                "    A minimum annual income of 400 million\n" +
                                                "    Facilities like electricity, drinking water, and communication\n" +
                                                "    Main Road and other link roads are pitched\n" +
                                                "    Availability of special health services like hospital, medical college etc.\n" +
                                                "    Has physical facilities for conducting international sports and games\n" +
                                                "    Sufficient opportunities are available for higher education with at least one university\n" +
                                                "    Has already become sub-metropolis\n" +
                                                "\n" +
                                                "Municipal Ward Committee\n" +
                                                "Each municipal area has been divided into a certain number of wards on the basis of geographical situations and population. At present, the minimum number of wards are 9 and maximum of 35. Award committee is formed in each ward which consists of the members elected by the adult citizen of the country living in the concerned ward. There shall be award chairperson, a woman ward member and three other ward members in the ward committee.\n" +
                                                "\n" +
                                                "Municipal Assembly\n" +
                                                "Every municipality there is a Municipal Assembly which is formed to create a plan, policy and give the budget of a municipality. Following are the members of this Assembly:\n" +
                                                "\n" +
                                                "    A Mayor, Deputy-Mayor of the municipality .\n" +
                                                "    Ward chairperson, women ward member and ward members of each ward.\n" +
                                                "    Six to 20 members with at least 40% women are nominated by the Municipal Assembly from socially and economically disadvantaged classes, social workers, suppressed tribal and aborigine communities who are qualified but not represented in Municipal Assembly.\n" +
                                                "\n" +
                                                "Power and Functions of Municipality\n" +
                                                "\n" +
                                                "To develop urban areas municipality is formed and here, it plays an important role.The municipality is entrusted with several responsibilities and duties. Functions of municipality are given below :\n" +
                                                "\n" +
                                                "    To prepare the annual budget, plans and programmes of the municipality .\n" +
                                                "    provide development in education through the establishment of primary schools,libraries providing scholarships to needy students and conducting adult education and non-formal education.\n" +
                                                "    providing encourage and develop spots through various programmes.And also to preserve and protect cultural and religious heritage .\n" +
                                                "    To implement plans and programmes relating to water supply, drainage, providing entertainment such as parks, gardens, playgrounds and public halls. etc.\n" +
                                                "    To the establishment of general hospitals, health centres, health post-Ayurvedic dispensaries and to run programmes concerning family planning mother-child welfare, public health etc.\n" +
                                                "    To run programmes based on social welfare like helping women , orphans , disabled and destitute children based on rehabilitation.\n";
                                        HashMap<String, String> lessons = new HashMap<>();
                                        lessons.put("name", lesso);
                                        lessons.put("number", String.valueOf(lesson));
                                        lessons.put("lesson", "lesson" + lesson);
                                        lessons.put("content", lesson1);
                                        dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    }if (lesson == 5) {
                                        String lesson1 = "Importance\n" +
                                                "\n" +
                                                "Education is important in life because it gives people the skills and tools they need to navigate the world. Education is a single and very important part of the individual development and the development of the nation.Education also influences people about the world in which they live, including information about history, philosophy, and culture. It also benefits in making the other people around him/her knowledgeable too .Many people believe that education is important in life for reasons behind basic survival ability. Eleanor Roosevelt famously said that education is essential to good citizenship and that education is important to everyone because it enables people to contribute to their community and their country. It also implements their learning into practical life.In this way, a community, a society, and a nation progress. Thus, education is necessary for the development of a country.\n" +
                                                "\n" +
                                                "Abroad Studies Opportunities\n" +
                                                "\n" +
                                                "Here, citizens are the most important resource of any country. But they need to be well educated, trained and encourage to carry out various works. Educations promote awareness and awareness present to all rounded development.A country can not well developed without education it can not progress at all. There is no lack of skilled and trained human resource where the literacy rate is very high achievement depends on the skillful and active human resources that resources are provided by education .\n" +
                                                "\n" +
                                                "Education in the past\n" +
                                                "\n" +
                                                "There was no formal educational instruction like schools and university but education is started in Nepal\n" +
                                                "\n" +
                                                "since ancient times.From their parent's children get occupation skills, social norms, and values.Ashram, Gumbas, Bihar etc. is a religious institution where education was imparted.Durbar High School has established in 1910 BS by Junga Bahadur Rana who took the initial step towards the formal English education.To make a life easy the country require a good doctors, teachers, engineers, farmers, researchers etc.The government has been putting an effort to make education available to all because of the low literacy rate of Nepal.The Government has initiated both formal and non-formal education in the country.A country has established five universities, several schools, and colleges which provide formal education.The non-formal education is managed as follows;\n" +
                                                "\n" +
                                                "    Education for the children who are not able to go school.\n" +
                                                "    Education for the aged people who is uneducated.\n" +
                                                "    Skilled based education for the women to increase their income.\n" +
                                                "    Special education for physically challenged, visually impaired, etc.\n";
                                        HashMap<String, String> lessons = new HashMap<>();
                                        lessons.put("name", lesso);
                                        lessons.put("number", String.valueOf(lesson));
                                        lessons.put("lesson", "lesson" + lesson);
                                        lessons.put("content", lesson1);
                                        dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    }if (lesson == 6) {
                                        String lesson1 = "Our Infrastructure of Development:Health\n" +
                                                "\n" +
                                                "One of the essential infrastructures of development is health.In a simple meaning being physically\n" +
                                                "\n" +
                                                "and mentally fit is known as the health.According to the definition of World Health Organization (WHO), \"Health is the state of complete physical,mental, and social well-being and not merely the absence of diseases or infirmity\".\n" +
                                                "\n" +
                                                "Importance\n" +
                                                "\n" +
                                                "As we know,health is essential for us even more than gold and diamond.A famous philosopher Josh Billings ???Health is like money, we never have a true idea of its value until we lose it\".So, the main intention of our life is to be healthy and happy.There is also saying that \"Health is Wealth.\" Which means a healthy person can think better, perform better, contribute more towards the development of the country.A famous Greek philosopher Aristotle has rightly said: \"A healthy mind exists in a healthy body\". country.The development of a country depends on the health of its citizens.following measures should take to remain healthy are:\n" +
                                                "\n" +
                                                "\n" +
                                                "    Keep your surrounding clean.\n" +
                                                "    Have a clean and safe drinking water.\n" +
                                                "    Eat a balanced diet containing vitamins, proteins,minerals etc.\n" +
                                                "    Avoid harmful habits of smoking,taking drugs and alcohol, etc.\n" +
                                                "    keeping yourself physically fit by exercise.\n" +
                                                "\n" +
                                                "Problems in health sector of Nepal\n" +
                                                "\n" +
                                                "Major problems in health sector of Nepal are as follows:\n" +
                                                "\n" +
                                                "    In a ruler area, a government has not been able to operate hospitals and manage doctors as wellSource:healthaffairs.org Fig: Health\n" +
                                                "\n" +
                                                "    as necessary tools,equipment, and medicines.\n" +
                                                "    There are no such health services in the remote areas because of the lack of facilities doctors are not interested in working there.\n" +
                                                "    Instead of going to doctors people prefer to go to witch doctors (Dhamijhankri).\n" +
                                                "    It is because due to the lack of education and awareness in remote areas.Also, can not even pay for doctor fee.\n" +
                                                "\n" +
                                                " \n" +
                                                "\n" +
                                                "Solutions\n" +
                                                "\n" +
                                                "    In rural areas,awareness program should launch by Government and non-government organization.\n" +
                                                "    In all parts of the country health posts and health centres should be established.And doctors are to be motivated to go to the remote areas.\n" +
                                                "    Mobile health camps should be conducted and blood donation programmes.\n" +
                                                "    Health education should be made compulsory in a school curriculum.\n";
                                        HashMap<String, String> lessons = new HashMap<>();
                                        lessons.put("name", lesso);
                                        lessons.put("number", String.valueOf(lesson));
                                        lessons.put("lesson", "lesson" + lesson);
                                        lessons.put("content", lesson1);
                                        dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    }
                                    lesson = lesson + 1;
                                }
                            }
                            if (num == 2) {
                                for (String lesso : g6socialchap2) {
                                    HashMap<String, String> lessons = new HashMap<>();
                                    lessons.put("name", lesso);
                                    lessons.put("number", String.valueOf(lesson));
                                    lessons.put("lesson", "lesson" + lesson);
                                    dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    lesson = lesson + 1;
                                }
                            }
                            if (num == 3) {
                                for (String lesso : g6socialchap3) {
                                    HashMap<String, String> lessons = new HashMap<>();
                                    lessons.put("name", lesso);
                                    lessons.put("number", String.valueOf(lesson));
                                    lessons.put("lesson", "lesson" + lesson);
                                    dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    lesson = lesson + 1;
                                }
                            }
                            if (num == 4) {
                                for (String lesso : g6socialchap4) {
                                    HashMap<String, String> lessons = new HashMap<>();
                                    lessons.put("name", lesso);
                                    lessons.put("number", String.valueOf(lesson));
                                    lessons.put("lesson", "lesson" + lesson);
                                    dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    lesson = lesson + 1;
                                }
                            }
                            if (num == 5) {
                                for (String lesso : g6socialchap5) {
                                    HashMap<String, String> lessons = new HashMap<>();
                                    lessons.put("name", lesso);
                                    lessons.put("number", String.valueOf(lesson));
                                    lessons.put("lesson", "lesson" + lesson);
                                    dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    lesson = lesson + 1;
                                }
                            }
                            if (num == 6) {
                                for (String lesso : g6socialchap6) {
                                    HashMap<String, String> lessons = new HashMap<>();
                                    lessons.put("name", lesso);
                                    lessons.put("number", String.valueOf(lesson));
                                    lessons.put("lesson", "lesson" + lesson);
                                    dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    lesson = lesson + 1;
                                }
                            }
                            if (num == 7) {
                                for (String lesso : g6socialchap7) {
                                    HashMap<String, String> lessons = new HashMap<>();
                                    lessons.put("name", lesso);
                                    lessons.put("number", String.valueOf(lesson));
                                    lessons.put("lesson", "lesson" + lesson);
                                    dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    lesson = lesson + 1;
                                }
                            }
                            if (num == 8) {
                                for (String lesso : g6socialchap8) {
                                    HashMap<String, String> lessons = new HashMap<>();
                                    lessons.put("name", lesso);
                                    lessons.put("number", String.valueOf(lesson));
                                    lessons.put("lesson", "lesson" + lesson);
                                    dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    lesson = lesson + 1;
                                }
                            }
                            if (num == 9) {
                                for (String lesso : g6socialchap9) {
                                    HashMap<String, String> lessons = new HashMap<>();
                                    lessons.put("name", lesso);
                                    lessons.put("number", String.valueOf(lesson));
                                    lessons.put("lesson", "lesson" + lesson);
                                    dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    lesson = lesson + 1;
                                }
                            }
                            if (num == 10) {
                                for (String lesso : g6socialchap10) {
                                    HashMap<String, String> lessons = new HashMap<>();
                                    lessons.put("name", lesso);
                                    lessons.put("number", String.valueOf(lesson));
                                    lessons.put("lesson", "lesson" + lesson);
                                    dbref.child(grade).child(sub).child("chapter" + num + "lesson").child("lesson" + lesson).setValue(lessons);
                                    lesson = lesson + 1;
                                }
                            }
                            num = num + 1;
                        }

                    }

                }
            }
            else if (grade.equals("grade7")) {
                for (String sub : subjects) {
                    if (sub.equals("english")) {
                        int num = 1;
                        for (String chap : g7english) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("mathematics")) {
                        int num = 1;
                        for (String chap : g7mathematics) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("nepali")) {
                        int num = 1;
                        for (String chap : g7nepali) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("science")) {
                        int num = 1;
                        for (String chap : g7sciene) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("social")) {
                        int num = 1;
                        for (String chap : g7social) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }

                }
            }
            else if (grade.equals("grade8")) {
                for (String sub : subjects) {
                    if (sub.equals("english")) {
                        int num = 1;
                        for (String chap : g8english) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("mathematics")) {
                        int num = 1;
                        for (String chap : g8mathematics) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("nepali")) {
                        int num = 1;
                        for (String chap : g8nepali) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("science")) {
                        int num = 1;
                        for (String chap : g8sciene) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("social")) {
                        int num = 1;
                        for (String chap : g8social) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }

                }
            }
            else if (grade.equals("grade9")) {
                for (String sub : subjects) {
                    if (sub.equals("english")) {
                        int num = 1;
                        for (String chap : g9english) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("mathematics")) {
                        int num = 1;
                        for (String chap : g9mathematics) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("nepali")) {
                        int num = 1;
                        for (String chap : g9nepali) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("science")) {
                        int num = 1;
                        for (String chap : g9sciene) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("social")) {
                        int num = 1;
                        for (String chap : g9social) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }

                }
            }
            else if (grade.equals("grade10")) {
                for (String sub : subjects) {
                    if (sub.equals("english")) {
                        int num = 1;
                        for (String chap : g10english) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("mathematics")) {
                        int num = 1;
                        for (String chap : g10mathematics) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("nepali")) {
                        int num = 1;
                        for (String chap : g10nepali) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("science")) {
                        int num = 1;
                        for (String chap : g10sciene) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("social")) {
                        int num = 1;
                        for (String chap : g10social) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }

                }
            }
            else if (grade.equals("grade11")) {
                for (String sub : subjects) {
                    if (sub.equals("english")) {
                        int num = 1;
                        for (String chap : g11english) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("mathematics")) {
                        int num = 1;
                        for (String chap : g11mathematics) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("nepali")) {
                        int num = 1;
                        for (String chap : g11nepali) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("science")) {
                        int num = 1;
                        for (String chap : g11sciene) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }
                    if (sub.equals("social")) {
                        int num = 1;
                        for (String chap : g11social) {
                            HashMap<String, String> chapter = new HashMap<>();
                            chapter.put("name", chap);
                            chapter.put("number", String.valueOf(num));
                            chapter.put("chap", "chapter" + num);
                            dbref.child(grade).child(sub).child("chapter" + num).setValue(chapter);
                            num = num + 1;
                        }

                    }

                }
            }
        }


    }
}