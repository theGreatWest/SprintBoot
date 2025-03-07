package com.example.memoryDB.practice.entity;

import lombok.Data;

@Data
public abstract class BaseEntity implements BasePrimaryKey {
    private Long id;
}
