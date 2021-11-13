/*
 * MIT License
 *
 * Copyright (c) 2021 EideeHi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.eidee.minecraft.experiencebottler.screen;

import net.eidee.minecraft.experiencebottler.core.constants.Identifiers;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.annotation.MethodsReturnNonnullByDefault;

/** Defines the screen handlers of the EXP Bottler. */
@MethodsReturnNonnullByDefault
public class ScreenHandlers {
  private static ScreenHandlerType<ExperienceBottlerScreenHandler> EXPERIENCE_BOTTLER;
  private static boolean initialized = false;

  private ScreenHandlers() {}

  /** Get the screen handler type of the EXP Bottler. */
  public static ScreenHandlerType<ExperienceBottlerScreenHandler> expBottler() {
    if (EXPERIENCE_BOTTLER == null) {
      throw new IllegalStateException("ScreenHandlers not initialized!");
    }
    return EXPERIENCE_BOTTLER;
  }

  /** Initialize the screen handler types. */
  public static void init() {
    if (initialized) {
      return;
    }
    initialized = true;

    EXPERIENCE_BOTTLER =
        ScreenHandlerRegistry.registerSimple(
            Identifiers.EXPERIENCE_BOTTLER, ExperienceBottlerScreenHandler::new);
  }
}
