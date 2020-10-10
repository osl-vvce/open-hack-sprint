package com.example.notesapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {
    private  NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application)
    {
        NoteDataBase dataBase=NoteDataBase.getInstance(application);             //application is the subclass of context.
        noteDao=dataBase.noteDao();
        allNotes=noteDao.getAllNotes();
    }

    public void insert(Note note)
    {
        new insertNoteAsyncTask(noteDao).execute(note);
    }

    public void update(Note note)
    {
        new updateNoteAsyncTask(noteDao).execute(note);
    }

    public void delete(Note note)
    {
        new deleteNoteAsyncTask(noteDao).execute(note);
    }

    public void deleteAllNotes()
    {
        new deleteAllNotesAsyncTask(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;   //room does all the code for this method.
    }

    private static class insertNoteAsyncTask extends AsyncTask<Note,Void,Void>
    {
        private static NoteDao noteDao;
        private insertNoteAsyncTask(NoteDao noteDao) {
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private static class updateNoteAsyncTask extends AsyncTask<Note,Void,Void>
    {
        private static NoteDao noteDao;
        private updateNoteAsyncTask(NoteDao noteDao) {
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }

    private static class deleteNoteAsyncTask extends AsyncTask<Note,Void,Void>
    {
        private static NoteDao noteDao;
        private deleteNoteAsyncTask(NoteDao noteDao) {
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }

    private static class deleteAllNotesAsyncTask extends AsyncTask<Void,Void,Void>
    {
        private static NoteDao noteDao;
        private deleteAllNotesAsyncTask(NoteDao noteDao) {
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }
}
