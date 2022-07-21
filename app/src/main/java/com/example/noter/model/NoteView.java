// View Model

package com.example.noter.model;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.noter.data.NoteRepo;

import java.util.List;

public class NoteView extends AndroidViewModel {

    private NoteRepo repo;

    private final LiveData<List<Note>> allNotes;

    public NoteView (Application application) {
        super(application);
        repo = new NoteRepo(application);
        allNotes= repo.getAllNotes();
    }

    public LiveData<List<Note>> getAllWords() { return allNotes; }

    public void insert(Note note) { repo.insert(note); }

}