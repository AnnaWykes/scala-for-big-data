implicit class RichString(s:String) {
    def isPalindrome: Boolean = s.reverse == s
  }
  
  object PalindromeGame extends App {
    val input = "true"
    if (input.isPalindrome) {
      println("You won! 🎉🎉")
    }
    else {
      println("You lost... 😔😔")
    }
  }