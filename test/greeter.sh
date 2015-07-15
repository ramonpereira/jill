#!/bin/bash

DIR=`dirname "$0"`

CP=${DIR}/../jill/target/jill-0.0.1-SNAPSHOT-jar-with-dependencies.jar:${DIR}/../examples/target/jill-examples-0.0.1-SNAPSHOT.jar:

# Connect the BDI system
CMD="java -cp ${CP} agentsoz.jill.Main -h"
echo $CMD; $CMD

a=100000
b=50
ID=greeter-${a}a-${b}b
echo ""
echo "Running $a agents with $b neighbours each (see ${ID}.*)"
CMD="java -Xmx2g -Xms2g -cp ${CP} agentsoz.jill.Main --agent-class agentsoz.jill.example.greeter.Greeter --logfile ${DIR}/${ID}.log --debug-level INFO --program-args \"-neighbourhoodSize $b\" --num-agents $a --plan-selection-policy LAST"
echo "Started at " `date`
echo $CMD; eval $CMD > ${DIR}/${ID}.out
echo "Finished at" `date`

a=50000
b=100
ID=greeter-${a}a-${b}b
echo ""
echo "Running $a agents with $b neighbours each (see ${ID}.*)"
CMD="java -Xmx2g -Xms2g -cp ${CP} agentsoz.jill.Main --agent-class agentsoz.jill.example.greeter.Greeter --logfile ${DIR}/${ID}.log --debug-level INFO --program-args \"-neighbourhoodSize $b\" --num-agents $a --plan-selection-policy LAST"
echo "Started at " `date`
echo $CMD; eval $CMD > ${DIR}/${ID}.out
echo "Finished at" `date`

a=10000
b=500
ID=greeter-${a}a-${b}b
echo ""
echo "Running $a agents with $b neighbours each (see ${ID}.*)"
CMD="java -Xmx2g -Xms2g -cp ${CP} agentsoz.jill.Main --agent-class agentsoz.jill.example.greeter.Greeter --logfile ${DIR}/${ID}.log --debug-level INFO --program-args \"-neighbourhoodSize $b\" --num-agents $a --plan-selection-policy LAST"
echo "Started at " `date`
echo $CMD; eval $CMD > ${DIR}/${ID}.out
echo "Finished at" `date`

