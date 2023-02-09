package util

class Validator {

    fun checkNames(names: String?) {
        checkNameNull(names)
        for (name in names!!.split(",")) {
            checkName(name.trim())
        }
    }

    fun checkName(name: String?) {
        checkNameNull(name)
        checkNameEmpty(name!!)
        checkNameSize(name)
        checkNameRight(name)
    }

    fun checkTryNumber(name: String?) {
        checkTryNumberNull(name)
        checkTryNumberIsRight(name)
    }

    private fun checkNameNull(name: String?) {
        require(name != null) { Constants.INPUT_NAME_NULL_ERROR_MESSAGE }
    }

    private fun checkNameSize(name: String) {
        require(name.length < 5) { Constants.INPUT_NAME_SIZE_ERROR_MESSAGE }
    }

    private fun checkNameEmpty(name: String) {
        require(name != "") { Constants.INPUT_NAME_NULL_ERROR_MESSAGE }
    }

    private fun checkNameRight(name: String) {
        require(name.contains("^[a-zA-Z가-힣]*$".toRegex())) { Constants.INPUT_NAME_RIGHT_ERROR_MESSAGE }
    }

    private fun checkTryNumberNull(number: String?) {
        require(number != null) { Constants.INPUT_TRY_NUMBER_NULL_ERROR_MESSAGE }
    }

    private fun checkTryNumberIsRight(number: String?) {
        try {
            number!!.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(Constants.INPUT_TRY_NUMBER_RIGHT_ERROR_MESSAGE)
        }
    }
}
