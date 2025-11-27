package com.example.agenda_contatos.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.agenda_contatos.data.Contato

@Dao
interface ContatoDao {
    @Query("SELECT * FROM contatos ORDER BY id DESC")
    fun getContatos(): LiveData<List<Contato>>

    @Query("SELECT * FROM contatos WHERE id = :id")
    fun getContato(id: Int): LiveData<Contato?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contato: Contato): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(contatos: List<Contato>)

    @Update
    suspend fun update(contato: Contato)

    @Delete
    suspend fun delete(contato: Contato)

    @Query("SELECT COUNT(*) FROM contatos")
    suspend fun count(): Int
}
