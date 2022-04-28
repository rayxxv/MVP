package com.example.mvp

interface MainView {
    fun showMessage(message: String)
    fun showData(data: String)
    fun clearField()
}