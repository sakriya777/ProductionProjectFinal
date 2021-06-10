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

        String[] g6nepali = {"गुरु",
                "युक्ति सामु शक्ति टिक्दैन",
                "सामाजिक सद्‍भाव",
                "भविष्यको योजना",
                "भवानी भिक्षु",
                "खोला",
                "साने र ठुले",
                "कृषिमलको प्रयोग",
                "दाजुलाई चिठी",
                "युमादेवीको अवतरण",
                "सम्पत्तिभन्दा शिक्षा ठूलो (वादविवाद)",
                "स्वाभिमानी मुख",
                "युधिष्ठिरको परीक्षा",
                "लुइ पास्चर",
                "वातावरणको रक्षा",
                "शङ्खधर शाख्वा",
                "मानिस नै देवता",
                "कलाको महत्त्व",
                "प्रध्यानधापकलाई निवेदन",
                "श्रीकृष्णको पराक्रम"
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
        String[] g7nepali = {"1.परिचय", "2.मामालाई सुधार्ने भान्जो", "3.सांस्कृतिक एकताको पर्व: छठ", "4.आन्तरिक पर्यटन", "5.साहित्यकार झमक", "6.एउटै मुटु एउटै मर्म", "7.सात दिने सभा", "8.प्रकृतिको सुन्दर स्थल: खप्तड", "9.साथीलाई चिठी", "10.सुन उगेल्ने भाले", "11.उद्‍योगलाई भन्दा कृषीलाई जोड", "12.सुनाैलो भोलि", "13.अलेक्जेन्डर फ्लेमिङ", "14.बोधिसत्वको कथा", "15.म सौर्य ऊर्जा हुँ", "16.रिस र राक्षस", "18.आबाल ब्रह्‍मचारी षडानन्द", "19.सभ्यता", "20.नेपालको धार्मिक वास्तुकला", "21.बाक्लो दाल"};
        String[] g7sciene = {"1.MEASUREMENT", "2.FORCE AND MOTION", "3.SIMPLE MACHINE", "4.PRESSURE", "5.ENERGY, WORK AND POWER", "6.HEAT", "7.LIGHT", "8.SOUND", "9.MAGNET", "10.ELECTRICITY", "11.MATTER", "12.MIXTURE", "13.METAL AND NON-METAL", "14.SOME USEFUL CHEMICALS", "15.LIVING BEINGS", "16.CELL AND TISSUE", "17.LIFE PROCESS", "18.STRUCTURE OF EARTH", "19.WEATHER AND CLIMATE", "20.EARTH AND SPACE", "21.ENVIRONMENT AND ITS BALANCE", "22.ENVIRONMENTAL DEGRADATION AND ITS CONSERVATION", "23.ENVIRONMENT AND SUSTAINABLE DEVELOPMENT"};
        String[] g7social = {"1.हामी र हाम्रो समाज", "2.हाम्रो सामाजिक मूल्य र मान्यता", "3.सामाजिक समस्या र समाधान", "4.नागरिक चेतना", "5.हाम्रो पृथ्वी", "6.हाम्रो विगत", "7.हाम्रो अार्थिक क्रियाकलाप", "8.हाम्रो अन्तर्राष्ट्रिय सम्बन्ध र सहयोग", "9.जनसङ्‌ख्या शिक्षाको परिचय र जनसाङ्‌ख्यिक अवस्था", "10.जनसङ्‌ख्या वृद्‌धि र व्यवस्थापन"};

        String[] g8english = {"TRAVELOGUE", "AN EXPEDITION", "BUSSINESS AND COMMERCE", "BIOGRAPHY", "FESTIVALS", "TECHNOLOGY", "JOURNALISM", "DANGERS OF JUNK FOOD", "MORAL STORIES", "HABITS AND BEHAVIOUR", "GAMES AND SPORTS", "DISTRICT PROFILE", "CHILDHOOD MEMORIES", "GRAPHS AND CHARTS", "LINCOLN'S LETTER", "FAIRY TALES", "FORMS AND CHEQUES", "DICTIONARY USE"};
        String[] g8mathematics = {"1. SET", "2. WHOLE NUMBER", "3. SQUARE ROOT AND CUBE ROOT", "4. RATIONALIZATION", "5. RATIONAL AND IRRATIONAL NUMBERS", "6. RATIO, PROPORTION AND PERCENTAGE", "7. PROFIT AND LOSS", "8. UNITARY METHOD", "9. SIMPLE INTEREST", "10. STATISTICS", "11. ALGEBRAIC EXPRESSION", "12. EQUATION, INEQUALITY AND GRAPH", "13. ANGLES AND PARALLEL LINES", "15. REGULAR POLYGON", "16. CONGRUENT AND SIMILAR TRIANGLES", "18. PERIMETER AND AREA OF TRIANGLE AND QUADRILATERAL", "19. CIRCLE", "20. CYLINDER AND PRISM", "21. TRANSFORMATION", "22. BEARING AND SCALE DRAWING"};
        String[] g8nepali = {"1. नेपाल", "2. भाग्य ", "3. देवकुमारी थापा", "4. ग्रन्थचित्र", "5. निवेदन लेखन", "6. मित्रता", "7. सिप र श्रम", "8. भूगोलविद् हर्क गुरुङ", "9. प्रकृति र वातावरण", "10. एउटा घटना", "11. घरायसी चिठी", "12. मेरो घर", "14. साहित्यकार रविन्द्रनाथ ठाकुर", "16. कम्प्युटर र इन्टरनेट", "17. हामी एउटै हाैँ - सारांश", "18. आह्‍वान", "19. सिंह र स्यालको कथा", "20. नेपाली संस्कृति", "21. सर आइज्याक न्युटन", "22. स्‍वाभिमान - कथा वाचन"};
        String[] g8sciene = {"1. MEASUREMENT", "2. VELOCITY AND ACCELERATION", "3. SIMPLE MACHINES", "4. PRESSURE", "5. ENERGY, WORK AND POWER", "6. HEAT", "7. LIGHT", "8. SOUND", "9. MAGNETISM", "10. ELECTRICITY", "11. MATTER", "12. MIXTURE", "13. METALS AND NON - METALS", "14. ACID, BASE AND SALT", "15. SOME USEFUL CHEMICALS", "16. LIVING BEINGS", "17. CELL AND TISSUE", "18. LIFE PROCESSES", "19. STRUCTURE OF EARTH", "20. WEATHER AND CLIMATE", "21. EARTH AND UNIVERSE", "22. ENVIRONMENT AND ITS BALANCE", "23. ENVIRONMENT DEGRADATION AND ITS CONSERVATION", "24. ENVIRONMENT AND SUSTAINABLE DEVELOPMENT"};
        String[] g8social = {"1. हामी, हाम्रो समुदाय र राष्ट्र", "2. हाम्रो सामाजिक मूल्य र मान्यता", "3. सामाजिक समस्या र समाधान", "4. नागरिक चेतना", "5. हाम्रो पृथ्वी", "6. हाम्रो विगत", "7. हाम्रो अार्थिक क्रियाकलाप", "8. हाम्रो अन्तर्राष्ट्रिय सम्बन्ध र सहयोग", "9. जनसङ्‌ख्याको परिचय र जनसाङ्‌ख्यिक अवस्था", "10. जनसङ्‌ख्या वृद्‌धि र व्यवस्थापन"};

        String[] g9english = {"MAKING PLANS AND EXPRESSING INTENTIONS", "SUGGESTING , ADVICING AND PERSUADING", "MAKING REQUEST AND RESPONDING TO THEM", "EXPRESSING CONDOLENCE AND SYMPATHY", "CRITICIZING AND EXPRESSING DEGREES OF PROBABILITY", "MAKING OFFERS AND RESPOND TO THEM", "GIVING INSTRUCTION AND DESCRIBING PURPOSE", "TALKING ABOUT PAST", "GIVING DIRECTION", "INTERPRETING GRAPHS, CHARTS AND DIAGRAMS", "DESCRIBING AN OBJECT OR A PLACE", "EXPRESSING ABILITY AND INABILITY", "EXPRESSING CONGRATULATIONS", "ASKING FOR PERMISSION", "APOLOGIZING AND RESPONDING TO THEM", "CREATIVE WRITING"};
        String[] g9mathematics = {"1. SETS", "2. PROFIT AND LOSS", "3. COMMISSION AND TAX", "4. HOME ARITHMETIC", "5. MENSURATION ( AREA)", "6. AREA AND VOLUME OF SOLID OBJECTS", "7. HCF AND LCM", "8. INDICES", "9. RATIO AND PROPORTION", "10. LINEAR EQUATION", "11. QUADRATIC EQUATION", "12. TRIANGLES", "13. PARALLELOGRAM", "14. CONSTRUCTION", "15. SIMILARITY", "16. CIRCLE", "17. TRIGONOMETRY", "18. STATISTIC", "19. PROBABILITY"};
        String[] g9nepali = {"1. अनारको बोट", "2. यात्रा सुरु गराैँ", "3. सङ्गीतज्ञ रामशरण दर्नाल", "4. म काे हुँ ?", "5. मानव बेचबिखन विरूद्ध हाम्राे दायित्व", "6. बहिनीलार्इ चिठी", "7. निद्रा", "8. वसन्त कोकिल", "9. जैविक खेती", "10. मङ्‍गलाका तिन दिन", "11. डाक्टर अङ्कल", "12. आङ सान सुकी", "13. सय रङ इन्द्रेनीको", "14. महिला हिंसा", "15. छात्रावास", "16. बन्धनबाट मुक्ति"};
        String[] g9sciene = {"1. MEASURMENT", "2. FORCE", "3. SIMPLE MACHINE", "4. WORK , ENERGY AND POWER", "5. LIGHT", "6. SOUND", "7. CURRENT ELECTRICITY AND MAGNETISM", "8. CLASSIFICATION OF ELEMENTS", "9. CHEMICAL REACTION", "10. SOLUBILITY", "11. SOME GASES", "12. METALS", "13. CARBON AND ITS COMPOUNDS", "14. WATER", "15. CHEMICAL FERTILIZER USED IN AGRICULTURE", "16. CLASSIFICATION OF PLANTS AND ANIMALS", "17. ADAPTATION OF ORGANISM", "18. SYSTEM", "19. SENSE ORGANS", "20. EVOLUTION", "21. NATURE AND ENVIRONMENT", "22. NATURAL HAZARD", "23. GREEN HOUSE", "24. THE EARTH IN THE UNIVERSE"};
        String[] g9social = {"2. विकास र विकासका पुर्वधारहरु", "5. नागरिक चेतना", "6. हाम्रो पृथ्वी", "8. आर्थिक क्रियाकलाप"};

        String[] g10english = {"UNIT 1: GIVING WITHHOLDING AND REPORTING PERMISSION", "UNIT 2: REPORTING STATEMENT", "UNIT 3: REPORTING QUESTIONS", "UNIT 4: REPORTING COMMANDS", "UNIT 5: GIVING ADVICE AND WARNINGS", "UNIT 6: EXPRESSING CONDITIONS", "UNIT 7: EXPRESSING CONDITIONS", "UNIT 8: ASKING FOR REASONS, PURPOSES AND THEIR RESPONSES", "UNIT 9: EXPRESSING UNEXPECTED RESULTS", "UNIT 10: DESCRIBING EVENTS", "UNIT 11: EXPRESSING PREFERENCES", "UNIT 12: TALKING ABOUT PERSONAL EXPERIENCE", "UNIT 13: TALKING ABOUT THE PAST (I) : NARRATING PAST EVENTS", "UNIT 14: TALKING ABOUT THE PAST (II): INTERRUPTED CONTINUOUS ACTION", "UNIT 15: TALKING ABOUT THE PAST (III): COMPARING PAST AND PRESENT", "UNIT 16: CONFIRMING AND DENYING", "UNIT 17: AGREEING AND DISAGREEING", "UNIT 18: INDICATING TIME AND MOTIONS", "UNIT 19: INTERPRETING TABLES AND CHARTS GLOSSARY",};
        String[] g10mathematics = {"1. SETS", "2. TAX AND MONEY EXCHANGE", "3. COMPOUND INTEREST", "4. POPULATION GROWTH AND COMPOUND DEPRECIATION", "5. PLANE SURFACE", "6. CYLINDER AND SPHERE", "7. PRISM AND PYRAMID", "8. H.C.F AND L.C.M", "9. RADICAL AND SURDS", "10. INDICES", "11. ALGEBRAIC FRACTION", "12. EQUATIONS", "13. TRIANGLES AND QUADRILATERAL", "14. CONSTRUCTION", "15. CIRCLE", "16. TRIGNOMETRY", "17. STATISTICS", "18. PROBABILITY"};
        String[] g10nepali = {"1. जन्मभूमि (कथा)", "2. सन्तुष्‍टि (कविता)", "3. सन्दुक रूइत (जीवनी)", "4. थाङ्‍का (निबन्ध)", "5. म पनि सक्छु (मनाेवाद)", "6. व्यापारिक चिठी (चिठी)", "7. प्रत्यागमन ( कथा)", "8. वर्षा (कविता)", "9. हाम्राे संस्कृति (निबन्ध)", "10. स्थानीयकरणभन्दा विश्‍वव्यापीकरण बेस (वादविवाद)", "11. लक्ष्मीपूजा (कथा)", "12. क्लारा जेटकिन (जीवनी)", "13. जय भुँडी ( निबन्ध)", "14. म सडक बाेल्दै छु (कविता)", "15. टीका (एकाङ‍्की)", "16. माउजङ बाबुसाहेबकाे काेट (कथा)"};
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
                                        String lesson1 = "As we know that, all of us live in a family where many families live together in a place it is called a neighborhood. In the same way, a group of family or people sharing a common understanding and often the same language, manners, tradition and law with each other is known as a community. We can not live alone because human beings are social animals. When we live in a community we can help each other to satisfy our needs which make our life comfortable and easier. Communities play a major role in the developments of societies and nations. They provide a program for people to come and exchange various ideas and experiences.Here, people of different occupation lives in a community some of them are pilot, teachers, doctors , engineers , farmers, tailors etc . Farmers work in the field and provide food for us, tailors make our dressed,Teachers give us the education whereas doctors check us when we are sick .In such way, we can help and co-operate with each other.Because of this, we can feel safer in a community than living alone . So, community plays an essential, role in our daily life . Simply from a community, we can learn a different culture, art , music , history, etc which are developed in the community. The community and its environment greatly influenced Language thought, and behaviors of the children. Community plays a major role in developing the mind of a child .Here.The government also plays a role in our life which helps to fulfill our demands and we can preserve our interest and rights.\n Society means the number of people living in a country, by honoring its laws and customs .On the basis of geography , religion , culture etc is formed by society. People lives in a society to satisfy each other needs.And also it consists of the people of different races, religions ages and classes .There are some similarity and difference between community and society .Community means a group of people living commonly, having some character in common but Society means the number of people living in a region, by accepting its laws and customs. The main difference between a community and a society is that a community is bound to a specific geographic location, but a society can be made up of the geographical boundary. community share common traits or interests whereas society honor and obey the pertinent laws and customs .Feeling of unity , attachment to each other, accountability , security , mutual understanding , etc the similarities found both in community and society .So community and society are equally essential for us.";
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
            } else if (grade.equals("grade7")) {
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
            } else if (grade.equals("grade8")) {
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
            } else if (grade.equals("grade9")) {
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
            } else if (grade.equals("grade10")) {
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
            } else if (grade.equals("grade11")) {
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