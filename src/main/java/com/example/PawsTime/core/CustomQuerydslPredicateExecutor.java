package com.example.PawsTime.core;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;
import java.util.function.Predicate;

public interface CustomQuerydslPredicateExecutor<T> extends QuerydslPredicateExecutor<T> {
}
