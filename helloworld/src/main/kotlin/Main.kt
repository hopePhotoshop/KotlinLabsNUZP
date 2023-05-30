import com.diacht.ktest.compose.startTestUi
import kotlinx.coroutines.*
import java.lang.Math.pow
import java.net.URL
import kotlin.math.cbrt
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.tan


fun seed(): String = "hopePhotoshop"

fun labNumber() : Int = 4
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
fun strCalculate(x0: String = "TCAGTAJCTJ", x1: String = "TCAGTAJJTJ"):
        Int {
    require(x0.length == x1.length) {
    }
    var result = 0
    for (i in x0.indices step 2) { // Цикл для проходження по рядку
        if (x0[i] != x1[i]) { // Порівняння символу першої строки з відповідним символом другої
            if ((x0[i] != 'T' && x0[i] != 'J') && (x1[i] != 'T' && x1[i] != 'J')) {
                result++

            }
        }
    }
    return(result)

}

suspend fun getNumberFromServer(s: String): Int {
    return withContext(Dispatchers.IO) {
        val url = URL("http://diacht.2vsoft.com/api/send-number?message=" + s)
        val connection = url.openConnection()
        connection.connect()
        val input = connection.getInputStream()
        val buffer = ByteArray(128)
        val bytesRead = input.read(buffer)
        input.close()
        String(buffer, 0, bytesRead).toInt()
    }
}

suspend fun serverDataCalculate(strList: List<String>) : Double = runBlocking {
    var result : Double = 0.0;
    val deferredList = strList.mapIndexed { index, element ->
        async {
            var number = getNumberFromServer(element).toDouble()
   pow(number,3.0)

        }
    }
    val numbers = deferredList.awaitAll()
    result = cbrt(numbers.sum())
println(result)
    return@runBlocking result;
}
    suspend fun main(args: Array<String>) {
        println("Лабораторна робота №${labNumber()} користувача ${seed()}")
        startTestUi(seed(),labNumber())
    }
