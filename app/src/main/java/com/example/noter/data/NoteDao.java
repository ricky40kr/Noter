// DAO

package com.example.noter.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.noter.model.Note;

import java.util.List;

@Dao
public interface NoteDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    // Run in background thread
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Note note);

    // Run in background thread
    @Query("DELETE FROM note_table")
    void deleteAll();

    @Query("SELECT * FROM note_table")
    LiveData<List<Note>> getAllNotes();

    // Run in background thread -> these threads are doing I/O operations which are heavy and can make the app laggy
}
