#!/bin/bash

PS3='Choose env [1, 2, 3] or exit [4]: '
options=("dev" "qa" "local" "exit")

function run_tests {
        echo "Which suite do you want to run? Type [regression, smoke]"
        read -p 'Suite: ' suite
        echo "Do you want to use grid? Type [yes, no]"
        read -p 'use grid (yes, no): ' grid
        ./mvnw clean install
        ./mvnw -P $suite,generate generate-test-sources
        if [ $grid == 'yes' ]
        then
        ./mvnw -P run integration-test -Denv=$env -Dselenide.remote="http://35.234.68.105:4444/wd/hub"
        ./mvnw -P generate-report post-integration-test
        elif [ $grid == 'no' ]
        then
        ./mvnw -P run integration-test -Denv=$env
        ./mvnw -P generate-report post-integration-test
        else
        echo "invalid option"
		break
        fi

}

select env in "${options[@]}"

do
    case $env in
        "dev")
        run_tests
        ;;
        "qa")
        run_tests
        ;;
        "local")
        run_tests
        ;;
        "exit")
            break
            ;;
        *) echo "invalid option";;
    esac
done


