import React, { useState, useCallback } from 'react';
import { useFocusEffect } from "@react-navigation/native";
import { View } from 'react-native';

import { gameInterface } from '../../interfaces/gameInterface';
import { clientGetWinner } from '../../api/api';
import { WinnerCard } from '../../components/Winner/WinnerCard'

import { styles } from './styles';

export function Winner() {
  const [game, setGame] = useState<gameInterface>({
    id: 0,
    name: '--',
    description: '--',
    cover: "",
    votes: 0
  });

  useFocusEffect(
    useCallback(() => {
      (async () => {
        const winner = await clientGetWinner()
        setGame(winner);
      })()
    }, [])
  )

  return (
    <View style={styles.container}>
      <WinnerCard
        name={game.name}
        cover={game.cover}
        votes={game.votes}
      />
    </View>
  );
}