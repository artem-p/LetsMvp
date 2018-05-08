package ru.artempugachev.letsmvp.data

data class User(val firstName: String, val lastName: String) {
    private var id = 0

    fun setId(id: Int) {
        this.id = id
    }
}