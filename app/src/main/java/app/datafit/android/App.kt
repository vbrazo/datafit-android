/*
 * Copyright (c) 2020 Vitor Oliveira
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package app.datafit.android

import android.app.Application
import android.content.Context

private const val KEY_PREFERENCES = "DataFit"
private const val KEY_TOKEN = "token"

private const val DIAMONDS = "DIAMONDS"
private const val EMAIL = "EMAIL"
private const val EXERCISE_TRAINING_COUNT = "EXERCISE_TRAINING_COUNT"
private const val EXERCISE_TRAINING_CURRENT_COUNT = "EXERCISE_TRAINING_CURRENT_COUNT"
private const val EXERCISE_TRAINING_CURRENT_SERIES = "EXERCISE_TRAINING_CURRENT_SERIES"
private const val EXERCISE_TRAINING_CURRENT = "EXERCISE_TRAINING_CURRENT"
private const val EXERCISE_TRAINING_ID = "EXERCISE_TRAINING_ID"
private const val EXERCISE_TRAINING_NAME = "EXERCISE_TRAINING_NAME"
private const val EXERCISE_TRAINING_REPETITIONS = "EXERCISE_TRAINING_REPETITIONS"
private const val EXERCISE_TRAINING_REST = "EXERCISE_TRAINING_REST"
private const val EXERCISE_TRAINING_VIDEO_LINK_ID = "EXERCISE_TRAINING_VIDEO_LINK_ID"
private const val LEVEL = "LEVEL"
private const val THUNDERS = "THUNDERS"
private const val TRAINING_DESCRIPTION = "TRAINING_DESCRIPTION"
private const val TRAINING_DURATION = "TRAINING_DURATION"
private const val TRAINING_ID = "TRAINING_ID"
private const val TRAINING_NAME = "TRAINING_NAME"
private const val TRAINING_COUNTER = "TRAINING_COUNTER"

class App : Application() {

  companion object {
    private lateinit var instance: App

    private val preferences by lazy {
      instance.getSharedPreferences(KEY_PREFERENCES, Context.MODE_PRIVATE)
    }

    fun saveEmail(email: String) {
      preferences.edit()
        .putString(EMAIL, email)
        .apply()
    }

    fun saveLevel(level: String) {
      preferences.edit()
        .putString(LEVEL, level)
        .apply()
    }

    fun saveExerciseTrainingId(exerciseTrainingId: String) {
      preferences.edit()
        .putString(EXERCISE_TRAINING_ID, exerciseTrainingId)
        .apply()
    }

    fun saveExerciseTrainingCurrent(currentIndex: String) {
      preferences.edit()
        .putString(EXERCISE_TRAINING_CURRENT, currentIndex)
        .apply()
    }

    fun saveExerciseTrainingCount(count: String) {
      preferences.edit()
        .putString(EXERCISE_TRAINING_COUNT, count)
        .apply()
    }

    fun saveExerciseTrainingName(name: String) {
      preferences.edit()
        .putString(EXERCISE_TRAINING_NAME, name)
        .apply()
    }

    fun saveExerciseTrainingRepetitions(repetitions: String) {
      preferences.edit()
        .putString(EXERCISE_TRAINING_REPETITIONS, repetitions)
        .apply()
    }

    fun saveExerciseTrainingSeriesCurrent(count: String){
      preferences.edit()
        .putString(EXERCISE_TRAINING_CURRENT_SERIES, count)
        .apply()
    }

    fun saveExerciseTrainingSeriesCount(count: String){
      preferences.edit()
        .putString(EXERCISE_TRAINING_CURRENT_COUNT, count)
        .apply()
    }

    fun saveExerciseTrainingRest(count: String){
      preferences.edit()
        .putString(EXERCISE_TRAINING_REST, count)
        .apply()
    }

    fun saveExerciseTrainingVideoLinkId(videoLinkId: String) {
      preferences.edit()
        .putString(EXERCISE_TRAINING_VIDEO_LINK_ID, videoLinkId)
        .apply()
    }

    fun saveToken(token: String) {
      preferences.edit()
        .putString(KEY_TOKEN, token)
        .apply()
    }

    fun saveThunders(token: String) {
      preferences.edit()
        .putString(THUNDERS, token)
        .apply()
    }

    fun saveDiamonds(token: String) {
      preferences.edit()
        .putString(DIAMONDS, token)
        .apply()
    }

    fun saveTrainingId(trainingId: String) {
      preferences.edit()
        .putString(TRAINING_ID, trainingId)
        .apply()
    }

    fun saveTrainingName(name: String){
      preferences.edit()
        .putString(TRAINING_NAME, name)
        .apply()
    }

    fun saveTrainingCounter(counter: Long) {
      preferences.edit()
        .putString(TRAINING_COUNTER, counter.toString())
        .apply()
    }

    fun saveTrainingDescription(name: String){
      preferences.edit()
        .putString(TRAINING_DESCRIPTION, name)
        .apply()
    }

    fun saveTrainingDuration(name: String){
      preferences.edit()
        .putString(TRAINING_DURATION, name)
        .apply()
    }

    fun getLevel() = preferences.getString(LEVEL, "") ?: ""
    fun getEmail() = preferences.getString(EMAIL, "") ?: ""
    fun getDiamonds() = preferences.getString(DIAMONDS, "") ?: ""
    fun getExerciseTrainingCount() = preferences.getString(EXERCISE_TRAINING_COUNT, "") ?: ""
    fun getExerciseTrainingCurrent() = preferences.getString(EXERCISE_TRAINING_CURRENT, "") ?: ""
    fun getExerciseTrainingId() = preferences.getString(EXERCISE_TRAINING_ID, "") ?: ""
    fun getExerciseTrainingName() = preferences.getString(EXERCISE_TRAINING_NAME, "") ?: ""
    fun getExerciseTrainingRepetitions() = preferences.getString(EXERCISE_TRAINING_REPETITIONS, "") ?: ""
    fun getExerciseTrainingSeriesCount() = preferences.getString(EXERCISE_TRAINING_CURRENT_COUNT, "") ?: ""
    fun getExerciseTrainingSeriesCurrent() = preferences.getString(EXERCISE_TRAINING_CURRENT_SERIES, "") ?: ""
    fun getExerciseTrainingRest() = preferences.getString(EXERCISE_TRAINING_REST, "") ?: ""
    fun getExerciseTrainingVideoLinkId() = preferences.getString(EXERCISE_TRAINING_VIDEO_LINK_ID, "") ?: ""
    fun getToken() = preferences.getString(KEY_TOKEN, "") ?: ""
    fun getThunders() = preferences.getString(THUNDERS, "") ?: ""
    fun getTrainingCounter() = preferences.getString(TRAINING_COUNTER, "") ?: ""
    fun getTrainingId() = preferences.getString(TRAINING_ID, "") ?: ""
    fun getTrainingName() = preferences.getString(TRAINING_NAME, "") ?: ""
    fun getTrainingDescription() = preferences.getString(TRAINING_DESCRIPTION, "") ?: ""
    fun getTrainingDuration() = preferences.getString(TRAINING_DURATION, "") ?: ""
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
  }
}