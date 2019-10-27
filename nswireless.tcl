################################################################
# wireless simulation related parameters                       #
################################################################
set val(chan)           Channel/WirelessChannel    ;# Channel Type
set val(prop)           Propagation/TwoRayGround   ;# radio-propagation model
set val(netif)          Phy/WirelessPhy            ;# network interface type
set val(mac)            Mac/802_11                 ;# MAC type
set val(ifq)            Queue/DropTail/PriQueue    ;# interface queue type
set val(ll)             LL                         ;# link layer type
set val(ant)            Antenna/OmniAntenna        ;# antenna model
set val(ifqlen)         50                         ;# max packet in ifq
set val(nn)             2                          ;# number of mobilenodes
set val(rp)             AODV                       ;# routing protocol
set val(x)		500
set val(y)		500

################################################################
# Initialization                                               #
# 1. create simulator                                          #
# 2. tracing                                                   #
# 3. define topography                                         #
################################################################
set ns		[new Simulator]

set tracefd     [open wireless-tcp.tr w]
$ns trace-all   $tracefd
set namtracefd    [open wireless-tcp.nam w]
$ns namtrace-all-wireless $namtracefd $val(x) $val(y)

set topo       [new Topography]
$topo load_flatgrid $val(x) $val(y)
create-god $val(nn)

################################################################
# Define/create/initialize nodes                               #
# 1. define nodes                                              #
# 2. create nodes                                              #
# 3. disable random motion                                     #
# 4. coordinates of wilress nodes                              #
# 5. nam setting, size and position                            #
################################################################
$ns node-config -adhocRouting $val(rp) \
		-llType $val(ll) \
		-macType $val(mac) \
		-ifqType $val(ifq) \
		-ifqLen $val(ifqlen) \
		-antType $val(ant) \
		-propType $val(prop) \
		-phyType $val(netif) \
		-topoInstance $topo \
		-agentTrace ON \
		-routerTrace ON \
		-macTrace ON \
		-movementTrace OFF \
		-channel [new $val(chan)]

set node_(0) [$ns node]
set node_(1) [$ns node]

$node_(0) random-motion 0
$node_(1) random-motion 0

$node_(0) set X_ 10.0
$node_(0) set Y_ 10.0
$node_(0) set Z_ 0.0
$node_(1) set X_ 30.0
$node_(1) set Y_ 30.0
$node_(1) set Z_ 0.0

for {set i 0} {$i < $val(nn)} {incr i} {
	$ns initial_node_pos $node_($i) 20 
}


################################################################
# Create traffic: a ftp/tcp connection                         #
################################################################
set tcp [new Agent/TCP]
$tcp set class_ 2
set sink [new Agent/TCPSink]
$ns attach-agent $node_(0) $tcp
$ns attach-agent $node_(1) $sink
$ns connect $tcp $sink
set ftp [new Application/FTP]
$ftp attach-agent $tcp

################################################################
# Schedule events                                              #
################################################################
$ns at 0.1 "$node_(1) setdest 350.0 350.0 400.0"
$ns at 0.4 "$ftp start" 
$ns at 1.0 "$node_(0) setdest 330.0 330.0 400.0"
$ns at 3.01 "stop"
$ns at 3.02 "puts \"NS EXITING...\" ; $ns halt"

################################################################
# 'stop' procedure                                             #
################################################################
proc stop {} {
    global ns tracefd namtracefd
    $ns flush-trace
    close $tracefd
    close $namtracefd

    puts "running nam..."
    exec nam wireless-tcp.nam &
    exit 0
}

################################################################
# start the simulation                                         #
################################################################
$ns run

