import subprocess
import os
import shutil
from pathlib import Path

ANNOTATOR_JAR = "{}/.m2/repository/edu/ucr/cs/riple/annotator/annotator-core/1.3.7-SNAPSHOT/annotator-core-1.3.7-SNAPSHOT.jar".format(str(Path.home()))
REPO = subprocess.check_output(['git', 'rev-parse', '--show-toplevel']).strip().decode('utf-8')


def prepare():
    os.makedirs('/tmp/annotator', exist_ok=True)
    shutil.rmtree('/tmp/annotator/0', ignore_errors=True)
    with open('/tmp/annotator/paths.tsv', 'w') as o:
        o.write("{}\t{}\n".format('/tmp/annotator/checker.xml', '/tmp/annotator/scanner.xml'))


def run_annotator():
    prepare()
    commands = []
    commands += ["java", "-jar", ANNOTATOR_JAR]
    commands += ['-d', '/tmp/annotator']
    commands += ['-bc', 'cd {} && ./gradlew compileJava'.format(REPO)]
    commands += ['-cp', '/tmp/annotator/paths.tsv']
    commands += ['-i', 'com.uber.nullaway.annotations.Initializer']
    commands += ['-n', 'javax.annotation.Nullable']
    commands += ['-cn', 'NULLAWAY']
    # Uncomment to see build output
    # commands += ['-rboserr']

    subprocess.call(commands)


run_annotator()
