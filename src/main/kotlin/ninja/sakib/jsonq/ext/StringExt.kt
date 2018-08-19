package ninja.sakib.jsonq.ext

/**
 * := Coded with love by Sakib Sami on 5/21/18.
 * := s4kibs4mi@gmail.com
 * := www.sakib.ninja
 * := Coffee : Dream : Code
 */


fun String.isInt(): Boolean {
    return this.toIntOrNull() != null
}
