package com.outlay.firebase;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.outlay.domain.model.User;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by bmelnychuk on 10/26/16.
 */

public class FirebaseRxWrapper {
    private FirebaseAuth firebaseAuth;

    @Inject
    public FirebaseRxWrapper() {
        //TODO shoud I provide as param
        this.firebaseAuth = FirebaseAuth.getInstance();
    }

    public Observable<AuthResult> signUp(String email, String password) {
        return Observable.create(subscriber -> {
            Task<AuthResult> task = firebaseAuth.createUserWithEmailAndPassword(email, password);
            task.addOnCompleteListener(resultTask -> {
                if (task.isSuccessful()) {
                    AuthResult authResult = task.getResult();
                    subscriber.onNext(authResult);
                    subscriber.onCompleted();
                } else {
                    Exception e = task.getException();
                    subscriber.onError(e);
                }
            });
        });
    }

    public Observable<AuthResult> signIn(String email, String password) {
        return Observable.create(subscriber -> {
            Task<AuthResult> task = firebaseAuth.signInWithEmailAndPassword(email, password);
            task.addOnCompleteListener(resultTask -> {
                if (task.isSuccessful()) {
                    AuthResult authResult = task.getResult();
                    subscriber.onNext(authResult);
                    subscriber.onCompleted();
                } else {
                    Exception e = task.getException();
                    subscriber.onError(e);
                }
            });
        });
    }

    public Observable<Void> resetPassword(User user) {
        return Observable.create(subscriber -> {
            Task<Void> task = firebaseAuth.sendPasswordResetEmail(user.getEmail());
            task.addOnCompleteListener(resultTask -> {
                if (task.isSuccessful()) {
                    subscriber.onCompleted();
                } else {
                    Exception e = task.getException();
                    subscriber.onError(e);
                }
            });
        });
    }
}
