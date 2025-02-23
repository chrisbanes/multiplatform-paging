# Releasing

1. Update the `version` in `build.gradle.kts` to the release version.

2. Update the `CHANGELOG.md`:
   1. Change the `Unreleased` header to the release version.
   2. Add a link URL to ensure the header link works.
   3. Add a new `Unreleased` section to the top.

3. Update the `README.md` so the "Download" section reflects the new release version and the
   snapshot section reflects the next "SNAPSHOT" version.

4. Commit

   ```
   $ git commit -am "Prepare version X.Y.X"
   ```

5. Tag

   ```
   $ git tag -am "Version X.Y.Z" X.Y.Z
   ```

6. Update the `version` in `build.gradle.kts` to the next "SNAPSHOT" version.

7. Commit

   ```
   $ git commit -am "Prepare next development version"
   ```

8. Push!

   ```
   $ git push && git push --tags
   ```

   This will trigger a GitHub Action workflow which will create a GitHub release,
   upload the release artifacts to [Sonatype Nexus](https://oss.sonatype.org/),
   and automatically promote those artifacts.

10. Create a new GitHub Release.

11. (optional) Link to release on Twitter/Mastodon.
