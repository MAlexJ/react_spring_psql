package com.malex.service;

import javax.annotation.Nonnull;

public interface IPropertiesReaderApp
{
    @Nonnull
    String getProperty(@Nonnull String propertyName);
}