package com.reali.enumiration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Type {
    FEATURE_COLLECTION("FeatureCollection"), FEATURE("Feature"), GEOMETRY("Point");

    String label;
}
