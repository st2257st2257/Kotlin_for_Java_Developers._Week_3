package nicestring

fun Boolean.toInt() = if (this) 1 else 0

fun condition1(str: String): Boolean {
    val stringArray: List<String> = str.split("b")
    for (i in 0 until (stringArray.size)){
        if (stringArray.elementAt(i) != "") {
            if (i == 0){
                if (str[0] == 'b'){
                    if (stringArray[0][0] in arrayOf('a', 'u', 'e')){
                        return false
                    }
                }
            }
            else{
                if (stringArray[i][0] in arrayOf('a', 'u', 'e')){
                    return false
                }
            }
        }
    }
    return true
}


fun condition2(str: String): Boolean {
    var flag: Int = 0
    for (item in str.toCharArray()){
        if (item in arrayOf('a', 'u', 'e', 'i', 'o')) flag += 1
    }
    return flag > 2
}


fun condition3(str: String): Boolean {
    var prev: Char = '~'
    var flag: Int = 0
    var prevprev: Char = '^'
    for (item in str.toCharArray()){
        if ((item == prev) && (prev != prevprev)){
            flag += 1
        }
        else{
            prevprev = prev
            prev = item
        }
    }
    return flag > 0
}

fun String.isNice(): Boolean {
    if((this.isNotEmpty()) &&
        (condition1(this).toInt() + condition2(this).toInt() + condition3(this).toInt() >= 2)){
        return true
    }
    return false
}
