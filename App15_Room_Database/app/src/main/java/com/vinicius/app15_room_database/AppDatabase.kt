package com.vinicius.app15_room_database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Tarefa::class), version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun tarefaDao():TarefaDAO
}
