package com.laurabarauna.controleVR.shared.usecase;

public abstract class UseCase<I, O> {
    public abstract O execute(I input);
}
