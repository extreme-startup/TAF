#!/bin/bash

PS3='Choose env [1, 2, 3] or exit [4]: '
options=("dev" "qa" "local" "exit")

function run_tests {
        echo "Which suite do you want to run? Type [regression, smoke]"
        read -p 'Suite: ' suite
        echo "Which type of tests do you want to run? Type [storefront, api]"
        read -p 'Suite: ' type
        echo "Do you want to use grid? Type [yes, no]"
        read -p 'use grid (yes, no): ' grid
        ./mvnw clean install
        ./mvnw -P $type,$suite,generate generate-test-sources
        if [ $grid == 'yes' ]
        then
        ./mvnw -P run integration-test -Denv=$env -Dselenide.remote="http://35.234.68.105:4444/wd/hub"
        ./mvnw -P generate-report post-integration-test
        show_report
        elif [ $grid == 'no' ]
        then
        ./mvnw -P run integration-test -Denv=$env
        ./mvnw -P generate-report post-integration-test
        show_report
        else
        echo "invalid option"
		break
        fi
}

function show_report {
echo "Do you want to see report after run? Type [yes, no]"
        read -p 'show report? (yes, no): ' report
         if [ $report == 'yes' ]
        then
        cd target/cluecumber-report
        echo $PWD
        start index.html
        open index.html
        xdg-open index.html
        else
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


