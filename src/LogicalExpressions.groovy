
/**
 * 
 * @author Sergey Doronin
 * Date: 21.05.12
 * Time: 11:16
 */

/**
 * Логические выражения
 */
def titanicBoxOffice = 1234600000
def titanicDirector = "Джеймса Кэмерона"

def trueLiesBoxOffice = 219000000
def trueLiesDirector = "Джеймса Кэмерона"

def returnOfTheKingBoxOffice = 752200000
def returnOfTheKingDirector = "Питер Джексон"

def theTwoTowersBoxOffice = 581200000
def theTwoTowersDirector = "PeterJackson"

titanicBoxOffice > returnOfTheKingBoxOffice // вычисляется как истина
titanicBoxOffice >= returnOfTheKingBoxOffice // вычисляется как истина
titanicBoxOffice >= titanicBoxOffice // вычисляется как истина
titanicBoxOffice > titanicBoxOffice // оценивается как ложное
titanicBoxOffice + trueLiesBoxOffice < returnOfTheKingBoxOffice + theTwoTowersBoxOffice // оценивается как ложное

titanicDirector > returnOfTheKingDirector // оценивается как ложное, потому что "J" находится перед "Р"
titanicDirector < returnOfTheKingDirector // вычисляется как истина
titanicDirector >= "Джеймса Кэмерона" // вычисляется как истина
titanicDirector == "Джеймса Кэмерона" // вычисляется как истина

if (titanicBoxOffice + trueLiesBoxOffice > returnOfTheKingBoxOffice + theTwoTowersBoxOffice) {
    println(titanicDirector + " is a better director than " + returnOfTheKingDirector)
}

def suvMap = ["Acura MDX" : "\$36,700", "Ford Explorer" : "\$26,845", "Hummer H3" : "\$65,000"]
if (suvMap["Hummer H2"] != null) {
    println("A Hummer H3 will set you back "+suvMap["Hummer H3"]);
} else {
    println "Not find!"
}