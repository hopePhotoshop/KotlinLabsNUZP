import com.diacht.ktest.compose.startTestUi
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.tan


fun seed(): String = "hopePhotoshop"

fun labNumber() : Int = 2
fun iCalculate(x0: Int = 83, x1: Int = -109, x2: Int = 91, x3: Int = -49, x4: Int = 27):
Double {
    val result = sin(x0.toDouble().pow(2) + x1.toDouble().pow(2) + x2.toDouble().pow(2) + x3.toDouble().pow(2) + x4.toDouble().pow(2))

    return(result)
}
fun dCalculate(x0: Double= -1.74, x1: Double= -34.65, x2:Double= 17.6, x3: Double= 70.4, x4: Double=1.62):
        Double{
    val result2 = tan(x0*x1*x2*x3*x4)
    return(result2)
}
fun strCalculate(x0: String = "ATGCJ", x1: String = "ATGCJ"):
        Int {
    require(x0.length == x1.length) {
    }
    var result3 = 0
    for (i in x0.indices step 2) {
        val symbol1 = x0[i]
        val symbol2 = x1[i]
        if (symbol1 == symbol2 || (symbol1 == 'T' && symbol2 == 'J') || (symbol1 == 'J' && symbol2 == 'T')) {
        } else {
            result3++
        }
    }
    return (result3)
            }

    fun main(args: Array<String>) {
        println("Лабораторна робота №${labNumber()} користувача ${seed()}")
        startTestUi(seed(),
            labNumber(),)
        iCalculate()
        dCalculate()
strCalculate()
    }


