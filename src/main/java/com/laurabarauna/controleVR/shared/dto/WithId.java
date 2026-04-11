package com.laurabarauna.controleVR.shared.dto;

public record WithId<TID, T> (TID id, T data) {
}
