import subprocess
import os
import shutil
from pathlib import Path

VERSION = '1.3.6-alpha-5'
ANNOTATOR_JAR = "{}/.m2/repository/edu/ucr/cs/riple/annotator/annotator-core/{}/annotator-core-{}.jar".format(str(Path.home()), VERSION, VERSION)
REPO = subprocess.check_output(['git', 'rev-parse', '--show-toplevel']).strip().decode('utf-8')


def prepare():
    os.makedirs('/tmp/annotator-libgdx-unopt', exist_ok=True)
    shutil.rmtree('/tmp/annotator-libgdx-unopt/0', ignore_errors=True)
    with open('/tmp/annotator-libgdx-unopt/paths.tsv', 'w') as o:
        o.write("{}\t{}\n".format('/tmp/annotator-libgdx-unopt/checker.xml', '/tmp/annotator-libgdx-unopt/scanner.xml'))


def run_annotator():
    prepare()
    commands = []
    commands += ["java", "-jar", ANNOTATOR_JAR]
    commands += ['-d', '/tmp/annotator-libgdx-unopt']
    commands += ['-bc', 'cd {} && ./gradlew compileJava'.format(REPO)]
    commands += ['-cp', '/tmp/annotator-libgdx-unopt/paths.tsv']
    commands += ['-i', 'com.uber.nullaway.annotations.Initializer']
    commands += ['-n', 'javax.annotation.Nullable']
    # Comment to enable fix impact cache
    commands += ['-dfc']
    # commands += ['-dc']
    # commands += ['-cn', 'NULLAWAY']
    commands += ["--depth", "5"]
    # Uncomment to see build output
    # commands += ['-rboserr']
    commands += ['-dpp']

    subprocess.call(commands)


run_annotator()
