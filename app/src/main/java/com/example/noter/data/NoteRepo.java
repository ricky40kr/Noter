package com.example.noter.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.noter.model.Note;
import com.example.noter.util.NoteRoomDB;

import java.util.List;

public class NoteRepo{
    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepo(Application application) {
        NoteRoomDB db = NoteRoomDB.getDatabase(application);
        this.noteDao = db.noteDao();
        allNotes = noteDao.getAllNotes();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Note note) {
        NoteRoomDB.databaseWriteExecutor.execute(() -> {
            noteDao.insert(note);
        });
    }
}
