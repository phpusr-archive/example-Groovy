
/**
 * 
 * @author Sergey Doronin
 * Date: 21.05.12
 * Time: 11:12
 */
/**
 * Условное исполнение
 */

def amPM = Calendar.getInstance().get(Calendar.AM_PM)

if (amPM == Calendar.AM) {
    println("Good morning")
} else {
    println("Good evening")
}