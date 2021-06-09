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

        String[] g7english = {  "PLACES TO VISIT",	 "TRAVEL EXCITEMENT",	 "LOCATIONS AND POSITIONS",	 "FAMOUS MONUMENTS",	 "WISHES AND CHOICES",	 "FAMOUS PEOPLE",	 "FESTIVALS IN NEPAL",	 "SEE THE DIFFERENCE",	 "A PLAN FOR A VISIT",	 "THE ENDANGERED SPECIES",	 "OUR VALUES",	 "GAMES AND SPORTS",	 "INSTRUCTIONS",	 "EXCURSION TO THE ZOO",	 "NARRATING EVENTS"};
        String[] g7mathematics = { "1.LINE AND ANGLE",	 "2.TRIANGLES",	 "3.SIMILARITY AND CONGRUENCY",	 "4.CIRCLE",	 "5.SOLID FIGURES",	 "6.CO-ORDINATE",	 "7.PERIMETER AND AREA",	 "8.TRANSFORMATION",	 "9.SYMMETRY AND TESSELLATION",	 "10.BEARING AND SCALING",	 "11.SET",	 "12.WHOLE NUMBER",	 "13.INTEGER",	 "14.RATIONAL NUMBER",	 "15.IRRATIONAL NUMBER",	 "16.FRACTION & DECIMAL",	 "17.RATIO, PROPORTION & PERCENT",	 "18.PROFIT & LOSS",	 "19.UNITARY METHOD",	 "20.SIMPLE INTEREST",	 "21.STATISTICS",	 "22.ALGEBRAIC EXPRESSION",	 "23.INDICES",	 "24.EQUATION, INEQUALITY AND LINE GRAPH"};
        String[] g7nepali = { "1.परिचय",	 "2.मामालाई सुधार्ने भान्जो",	 "3.सांस्कृतिक एकताको पर्व: छठ",	 "4.आन्तरिक पर्यटन",	 "5.साहित्यकार झमक",	 "6.एउटै मुटु एउटै मर्म",	 "7.सात दिने सभा",	 "8.प्रकृतिको सुन्दर स्थल: खप्तड",	 "9.साथीलाई चिठी",	 "10.सुन उगेल्ने भाले",	 "11.उद्‍योगलाई भन्दा कृषीलाई जोड",	 "12.सुनाैलो भोलि",	 "13.अलेक्जेन्डर फ्लेमिङ",	 "14.बोधिसत्वको कथा",	 "15.म सौर्य ऊर्जा हुँ",	 "16.रिस र राक्षस",	 "18.आबाल ब्रह्‍मचारी षडानन्द",	 "19.सभ्यता",	 "20.नेपालको धार्मिक वास्तुकला",	 "21.बाक्लो दाल"};
        String[] g7sciene = {"1.MEASUREMENT",	"2.FORCE AND MOTION",	"3.SIMPLE MACHINE",	"4.PRESSURE",	"5.ENERGY, WORK AND POWER",	"6.HEAT",	"7.LIGHT",	"8.SOUND",	"9.MAGNET",	"10.ELECTRICITY",	"11.MATTER",	"12.MIXTURE",	"13.METAL AND NON-METAL",	"14.SOME USEFUL CHEMICALS",	"15.LIVING BEINGS",	"16.CELL AND TISSUE",	"17.LIFE PROCESS",	"18.STRUCTURE OF EARTH",	"19.WEATHER AND CLIMATE",	"20.EARTH AND SPACE",	"21.ENVIRONMENT AND ITS BALANCE",	"22.ENVIRONMENTAL DEGRADATION AND ITS CONSERVATION",	"23.ENVIRONMENT AND SUSTAINABLE DEVELOPMENT"};
        String[] g7social = {"1.हामी र हाम्रो समाज",	"2.हाम्रो सामाजिक मूल्य र मान्यता",	"3.सामाजिक समस्या र समाधान",	"4.नागरिक चेतना",	"5.हाम्रो पृथ्वी",	"6.हाम्रो विगत",	"7.हाम्रो अार्थिक क्रियाकलाप",	"8.हाम्रो अन्तर्राष्ट्रिय सम्बन्ध र सहयोग",	"9.जनसङ्‌ख्या शिक्षाको परिचय र जनसाङ्‌ख्यिक अवस्था",	"10.जनसङ्‌ख्या वृद्‌धि र व्यवस्थापन"};

        String[] subjects = {"english", "mathematics", "nepali", "science", "social"};

        String[] grades = {"grade6", "grade7", "grade8", "grade9", "grade10"};

        for (String grade : grades){
            if (grade.equals("grade6")){
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
                            num = num + 1;
                        }

                    }

                }
            }
            else if (grade.equals("grade7")){
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
        }


    }
}