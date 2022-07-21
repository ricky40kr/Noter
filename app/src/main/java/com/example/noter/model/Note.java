// Entity

package com.example.noter.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "note")
    private final String note;

    public Note(@NonNull String note) {
        this.note = note;
    }

    @NonNull
    public String getNote() {
        return note;
    }
}
